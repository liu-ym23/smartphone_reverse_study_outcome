package com.obric.cae.userAware.ui;

import android.app.AlertDialog;
import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.lifecycle.LiveData;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.UserAwareManager;
import com.obric.cae.userAware.datacollection.FileController;
import com.obric.cae.userAware.datacollection.UploadWorker;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.cae.utils.CaeUtil;
import com.obric.oui.button.OButton;
import com.obric.oui.titlebar.OCTitleBar;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class CompanySceneCollectActivity extends androidx.fragment.app.m {
    private static final int COLLECT_TIMEOUT_MS = 900000;
    private OButton btnEnd;
    private OButton btnStart;
    private View btnUpload;
    private SceneType currentScene;
    private File currentSessionDir;
    private EditText etFloor;
    private long lastBackPressedTime;
    private long lastClickTimestamp;
    private boolean mUpdatingSelection;
    private RadioButton rbCompanyArrive;
    private RadioButton rbCompanyLeave;
    private RadioButton rbHomeArrive;
    private RadioButton rbHomeLeave;
    private String sessionDescCached;
    private CollectState state;
    private LinearLayout tagContainer;
    private TextView tvTagSubtitle;
    private UUID uploadWorkerId;
    private LiveData<androidx.work.u> workInfoLiveData;
    private androidx.lifecycle.u<androidx.work.u> workInfoObserver;

    /* JADX INFO: renamed from: com.obric.cae.userAware.ui.CompanySceneCollectActivity$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType = null;

        static {
            int[] r8 = new int[SceneType.values().length];
            $SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType = r8;
            r8[SceneType.HOME_ARRIVE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType[SceneType.COMPANY_ARRIVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType[SceneType.HOME_LEAVE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType[SceneType.COMPANY_LEAVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static final enum CollectState extends Enum<CollectState> {
        private static final /* synthetic */ CollectState[] $VALUES = null;
        public static final CollectState COLLECTING = null;
        public static final CollectState IDLE = null;

        private static /* synthetic */ CollectState[] $values() {
            return new CollectState[]{IDLE, COLLECTING};
        }

        static {
            IDLE = new CollectState("IDLE", 0);
            COLLECTING = new CollectState("COLLECTING", 1);
            $VALUES = $values();
        }

        private CollectState(String r8, int r10) {
            super(r8, r10);
        }

        public static CollectState valueOf(String r8) {
            return (CollectState) Enum.valueOf(CollectState.class, r8);
        }

        public static CollectState[] values() {
            return (CollectState[]) $VALUES.clone();
        }
    }

    public static final enum SceneType extends Enum<SceneType> {
        private static final /* synthetic */ SceneType[] $VALUES = null;
        public static final SceneType COMPANY_ARRIVE = null;
        public static final SceneType COMPANY_LEAVE = null;
        public static final SceneType HOME_ARRIVE = null;
        public static final SceneType HOME_LEAVE = null;

        private static /* synthetic */ SceneType[] $values() {
            return new SceneType[]{HOME_ARRIVE, COMPANY_ARRIVE, HOME_LEAVE, COMPANY_LEAVE};
        }

        static {
            HOME_ARRIVE = new SceneType("HOME_ARRIVE", 0);
            COMPANY_ARRIVE = new SceneType("COMPANY_ARRIVE", 1);
            HOME_LEAVE = new SceneType("HOME_LEAVE", 2);
            COMPANY_LEAVE = new SceneType("COMPANY_LEAVE", 3);
            $VALUES = $values();
        }

        private SceneType(String r8, int r10) {
            super(r8, r10);
        }

        public static SceneType valueOf(String r8) {
            return (SceneType) Enum.valueOf(SceneType.class, r8);
        }

        public static SceneType[] values() {
            return (SceneType[]) $VALUES.clone();
        }
    }

    public static final enum StairType extends Enum<StairType> {
        private static final /* synthetic */ StairType[] $VALUES = null;
        public static final StairType ELEVATOR = null;
        public static final StairType ESCALATOR = null;
        public static final StairType STAIRS = null;

        private static /* synthetic */ StairType[] $values() {
            return new StairType[]{ELEVATOR, ESCALATOR, STAIRS};
        }

        static {
            ELEVATOR = new StairType("ELEVATOR", 0);
            ESCALATOR = new StairType("ESCALATOR", 1);
            STAIRS = new StairType("STAIRS", 2);
            $VALUES = $values();
        }

        private StairType(String r8, int r10) {
            super(r8, r10);
        }

        public static StairType valueOf(String r8) {
            return (StairType) Enum.valueOf(StairType.class, r8);
        }

        public static StairType[] values() {
            return (StairType[]) $VALUES.clone();
        }
    }

    public CompanySceneCollectActivity() {
        this.state = CollectState.IDLE;
        this.mUpdatingSelection = false;
        this.lastBackPressedTime = 0;
        this.lastClickTimestamp = 0;
    }

    private void addStairStartItem(final boolean r12) {
        if (r12 == false) goto L4;
        int r8 = R.string.debug_company_stair_up_start_title;
    L5:
        String r10 = getString(r8);
        if (r12 == false) goto L8;
        int r11 = R.string.debug_company_stair_up_start_hint;
    L9:
        String r13 = getString(r11);
        final View r14 = LayoutInflater.from(this).inflate(R.layout.list_item_record, null);
        final TextView r15 = (TextView) r14.findViewById(R.id.content_text);
        final TextView r16 = (TextView) r14.findViewById(R.id.status_text);
        r15.setText(r10);
        r16.setText(r13);
        r16.setTextColor(Color.parseColor("#808080"));
        r16.setTextSize(2, 12.0f);
        r14.setClickable(true);
        r14.setFocusable(true);
        r14.setBackgroundResource(android.R.drawable.list_selector_background);
        r14.setOnClickListener(new a(this, r12, r16, r14, r15));
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, -2);
        r17.setMargins(16, 6, 16, 0);
        this.tagContainer.addView(r14, r17);
        return;
    L8:
        r11 = R.string.debug_company_stair_down_start_hint;
        goto L9
    L4:
        r8 = R.string.debug_company_stair_down_start_title;
        goto L5
    }

    private void addTagItem(String r10, String r11, final Runnable r12) {
        final View r8 = LayoutInflater.from(this).inflate(R.layout.list_item_record, null);
        final TextView r13 = (TextView) r8.findViewById(R.id.content_text);
        final TextView r14 = (TextView) r8.findViewById(R.id.status_text);
        r13.setText(r10);
        r14.setText(r11);
        r14.setTextColor(Color.parseColor("#808080"));
        r14.setTextSize(2, 12.0f);
        r8.setClickable(true);
        r8.setFocusable(true);
        r8.setBackgroundResource(android.R.drawable.list_selector_background);
        r8.setOnClickListener(new d(this, r12, r8, r13, r14));
        LinearLayout.LayoutParams r15 = new LinearLayout.LayoutParams(-1, -2);
        r15.setMargins(16, 6, 16, 0);
        this.tagContainer.addView(r8, r15);
    }

    private boolean allowClick() {
        long r8 = System.currentTimeMillis();
        if ((r8 - this.lastClickTimestamp) >= 1000) goto L6;
        return false;
    L6:
        this.lastClickTimestamp = r8;
        return true;
    }

    public static /* synthetic */ void d(CompanySceneCollectActivity r8, View r10) {
        r8.lambda$onCreate$0(r10);
    }

    private boolean deleteRecursive(File r8) {
        boolean r10 = true;
        if (r8 != null) goto L6;
        return true;
    L6:
        if (r8.isDirectory() == false) goto L23;
        File[] r11 = r8.listFiles();
        if (r11 != null) goto L10;
        CaeLog.w("CompanyScene", "List files returned null for: " + r8.getAbsolutePath());
        goto L23
    L10:
        int r12 = r11.length;
        int r13 = 0;
    L11:
        if (r13 >= r12) goto L23;
        if (deleteRecursive(r11[r13]) == true) goto L15;
        r10 = false;
    L15:
        r13 = r13 + 1;
    L23:
        boolean r14 = r8.delete();     // Catch: SecurityException -> L18
    L19:
        if (r14 == true) goto L21;
        CaeLog.w("CompanyScene", "Delete failed: " + r8.getAbsolutePath());
        return false;
    L21:
        CaeLog.i("CompanyScene", "Deleted: " + r8.getAbsolutePath());
        return r10;
    L18:
        CaeLog.e("CompanyScene", "Delete failed (SecurityException): " + r8.getAbsolutePath());
        r14 = false;
        r10 = false;
        goto L19
    }

    public static /* synthetic */ void e(CompanySceneCollectActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showPreCollectDialog$5(r10, r11);
    }

    private void ensureWorkManagerInitialized() {
        androidx.work.c.a r8 = new androidx.work.c.a();     // Catch: IllegalStateException -> L5
        r8.f2806b = 4;     // Catch: IllegalStateException -> L5
        r8.f2805a = getApplicationContext().getPackageName();     // Catch: IllegalStateException -> L5
        androidx.work.c r10 = new androidx.work.c(r8);     // Catch: IllegalStateException -> L5
        j1.b0.i(getApplicationContext(), r10);     // Catch: IllegalStateException -> L5
        CaeLog.i("CompanyScene", "WorkManager initialized");     // Catch: IllegalStateException -> L5
        return;
    L5:
        CaeLog.w("CompanyScene", "WorkManager already initialized");
    }

    public static /* synthetic */ void f(DialogInterface r8, int r10) {
        lambda$showPreCollectDialog$6(r8, r10);
    }

    public static /* synthetic */ void g(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$9();
    }

    public static /* synthetic */ void h(CompanySceneCollectActivity r8, TextView r10, String[] r11, boolean r12, DialogInterface r13, int r14) {
        r8.lambda$showStairTypeDialog$18(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void i(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$15();
    }

    private void initViews() {
        this.rbHomeArrive = (RadioButton) findViewById(R.id.rb_home_arrive);
        this.rbCompanyArrive = (RadioButton) findViewById(R.id.rb_company_arrive);
        this.rbHomeLeave = (RadioButton) findViewById(R.id.rb_home_leave);
        this.rbCompanyLeave = (RadioButton) findViewById(R.id.rb_company_leave);
        this.btnStart = (OButton) findViewById(R.id.btn_start);
        this.btnEnd = (OButton) findViewById(R.id.btn_end);
        this.tagContainer = (LinearLayout) findViewById(R.id.card_tags);
        this.tvTagSubtitle = (TextView) findViewById(R.id.tv_tag_subtitle);
        this.etFloor = (EditText) findViewById(R.id.et_floor);
    }

    public static /* synthetic */ void j(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$12();
    }

    public static /* synthetic */ void k(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$11();
    }

    public static /* synthetic */ void l(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$14();
    }

    private /* synthetic */ void lambda$addStairStartItem$17(boolean r8, TextView r10, View r11, TextView r12, View r13) {
        if (allowClick() == true) goto L6;
        return;
    L6:
        if (this.state == CollectState.COLLECTING) goto L9;
        Toast.makeText(this, getString(R.string.debug_company_tag_need_start_collect), 0).show();
        return;
    L9:
        showStairTypeDialog(r8, r10);
        r11.setClickable(false);
        r11.setEnabled(false);
        r11.setAlpha(0.5f);
        r12.setTextColor(Color.parseColor("#808080"));
        r10.setTextColor(Color.parseColor("#808080"));
    }

    private /* synthetic */ void lambda$addTagItem$16(Runnable r8, View r10, TextView r11, TextView r12, View r13) {
        if (allowClick() == true) goto L6;
        return;
    L6:
        if (this.state == CollectState.COLLECTING) goto L9;
        Toast.makeText(this, getString(R.string.debug_company_tag_need_start_collect), 0).show();
        return;
    L9:
        r8.run();
        r10.setClickable(false);
        r10.setEnabled(false);
        r10.setAlpha(0.5f);
        r11.setTextColor(Color.parseColor("#808080"));
        r12.setTextColor(Color.parseColor("#808080"));
    }

    private /* synthetic */ void lambda$onCreate$0(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$onCreate$1(View r8) {
        if (allowClick() == true) goto L5;
        return;
    L5:
        startUploadBasic();
    }

    private /* synthetic */ void lambda$renderTagsForScene$10() {
        recordTag("enter_floor_gate");
    }

    private /* synthetic */ void lambda$renderTagsForScene$11() {
        recordTag("sit_down");
    }

    private /* synthetic */ void lambda$renderTagsForScene$12() {
        recordTag("stand_up");
    }

    private /* synthetic */ void lambda$renderTagsForScene$13() {
        recordTag("leave_home_gate");
    }

    private /* synthetic */ void lambda$renderTagsForScene$14() {
        recordTag("down_finish");
    }

    private /* synthetic */ void lambda$renderTagsForScene$15() {
        recordTag("leave_building");
    }

    private /* synthetic */ void lambda$renderTagsForScene$8() {
        recordTag("enter_building");
    }

    private /* synthetic */ void lambda$renderTagsForScene$9() {
        recordTag("up_finish");
    }

    private /* synthetic */ void lambda$setupButtons$3(View r8) {
        if (allowClick() == true) goto L6;
        return;
    L6:
        if (this.currentScene != null) goto L9;
        Toast.makeText(this, getString(R.string.debug_company_select_scene_prompt), 0).show();
        return;
    L9:
        showPreCollectDialog();
    }

    private /* synthetic */ void lambda$setupButtons$4(View r8) {
        if (allowClick() == true) goto L5;
        return;
    L5:
        showEndConfirmDialog();
    }

    private /* synthetic */ void lambda$setupSceneSelection$2(CompoundButton r8, boolean r10) {
        if (this.mUpdatingSelection == false) goto L5;
        return;
    L5:
        if (r10 == true) goto L8;
        return;
    L8:
        if (this.state != CollectState.COLLECTING) goto L11;
        return;
    L11:
        if (r8 != this.rbHomeArrive) goto L15;
        SceneType r11 = SceneType.HOME_ARRIVE;
    L13:
        selectScene(r11);
        return;
    L15:
        if (r8 != this.rbCompanyArrive) goto L18;
        r11 = SceneType.COMPANY_ARRIVE;
        goto L13
    L18:
        if (r8 != this.rbHomeLeave) goto L21;
        r11 = SceneType.HOME_LEAVE;
        goto L13
    L21:
        if (r8 != this.rbCompanyLeave) goto L24;
        r11 = SceneType.COMPANY_LEAVE;
        goto L13
    }

    private /* synthetic */ void lambda$showEndConfirmDialog$19(DialogInterface r8, int r10) {
        stopCollect();
    }

    private static /* synthetic */ void lambda$showEndConfirmDialog$20(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showEndConfirmDialog$21(DialogInterface r8, int r10) {
        stopCollectInternal(true);
        File r11 = this.currentSessionDir;
        if (r11 != null) goto L5;
    L7:
        CaeLog.w("CompanyScene", "Discard skipped: session dir is null or not exists");
    L8:
        this.currentSessionDir = null;
        return;
    L5:
        if (r11.exists() == false) goto L7;
        CaeLog.i("CompanyScene", "Discard attempt on dir: " + r11.getAbsolutePath());
        CaeLog.i("CompanyScene", "Discard finished, success=" + deleteRecursive(r11) + ", existsAfter=" + r11.exists());
        goto L8
    }

    private /* synthetic */ void lambda$showPreCollectDialog$5(DialogInterface r8, int r10) {
        startCollect();
    }

    private static /* synthetic */ void lambda$showPreCollectDialog$6(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showPreCollectDialog$7(DialogInterface r8, int r10) {
        Intent r11 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");     // Catch: ActivityNotFoundException -> L4
        r11.setData(Uri.fromParts("package", getPackageName(), null));     // Catch: ActivityNotFoundException -> L4
        startActivity(r11);     // Catch: ActivityNotFoundException -> L4
        return;
    L4:
        CaeLog.e("CompanyScene", "App settings not found");
    }

    private /* synthetic */ void lambda$showStairTypeDialog$18(TextView r8, String[] r10, boolean r11, DialogInterface r12, int r13) {
        if (r13 != 0) goto L5;
        StairType r14 = StairType.ELEVATOR;
    L8:
        r8.setText(r10[r13]);
        if (r11 == false) goto L11;
        StringBuilder r15 = new StringBuilder("up_start:");
    L12:
        r15.append(r14.name());
        recordTag(r15.toString());
        r12.dismiss();
        return;
    L11:
        r15 = new StringBuilder("down_start:");
        goto L12
    L5:
        if (r13 != 1) goto L7;
        r14 = StairType.ESCALATOR;
        goto L8
    L7:
        r14 = StairType.STAIRS;
        goto L8
    }

    private void lambda$startUploadBasic$22(androidx.work.u r13) {
        if (r13 != null) goto L4;
        return;
    L4:
        androidx.work.e r8 = r13.f2949e;
        String r10 = r8.d("type");
        if (r10 != null) goto L7;
    L26:
        androidx.work.u.a r14 = r13.f2946b;
        if (r14.a() == false) goto L56;
        String r11 = UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_done);
        if (r14 != androidx.work.u.a.f2955n) goto L32;
        Application r15 = getApplication();
        int r12 = R.string.user_aware_upload_failed;
    L34:
        r11 = UserAwareUtil.getStringValueFromXML(r15, r12);
    L51:
        CaeUtil.showShortToast(this, r11);
        return;
    L32:
        if (r14 != androidx.work.u.a.f2957p) goto L36;
        r15 = getApplication();
        r12 = R.string.user_aware_upload_cancelled;
        goto L34
    L36:
        if (r14 != androidx.work.u.a.f2954m) goto L51;
        File r16 = UserAwareUtil.getNearbyLogPathFile(getApplicationContext());
        if (r16 == null) goto L51;
        if (r16.exists() == false) goto L51;
        if (r16.isDirectory() == false) goto L51;
        CaeLog.i("CompanyScene", "Upload succeeded, cleaning directory: " + r16.getAbsolutePath());
        File[] r17 = r16.listFiles();
        if (r17 == null) goto L51;
        int r18 = r17.length;
        int r19 = 0;
    L46:
        if (r19 >= r18) goto L51;
        File r20 = r17[r19];
        if (deleteRecursive(r20) == true) goto L50;
        CaeLog.w("CompanyScene", "Delete child failed: " + r20.getAbsolutePath());
    L50:
        r19 = r19 + 1;
        goto L46
    L56:
        return;
    L7:
        if (r10.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_OVERALL) == false) goto L16;
        long r21 = r8.c(UploadWorker.KEY_PROGRESS_TOTAL_FILE_COUNT_TO_UPLOAD);
        long r22 = r8.c(UploadWorker.KEY_PROGRESS_UPLOADED_FILE_COUNT);
        double r23 = Math.min(r8.b(UploadWorker.KEY_PROGRESS_PERCENTAGE_BY_SIZE, -1.0d), 100.0d);
        if (r21 == (-1)) goto L26;
        if (r22 == (-1)) goto L26;
        if (r23 < 0.0d) goto L26;
        String r24 = String.format(Locale.getDefault(), "%s %d/%d %s(%.1f%%)", new Object[]{UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_overall_text), Long.valueOf(r22), Long.valueOf(r21), UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_file), Double.valueOf(r23)});
    L25:
        CaeUtil.showShortToast(this, r24);
        goto L26
    L16:
        if (r10.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_CURRENT_FILE) == false) goto L21;
        String r25 = r8.d(UploadWorker.KEY_PROGRESS_FILE_NAME);
        double r26 = Math.min(r8.b(UploadWorker.KEY_PROGRESS_CURRENT_FILE_PERCENTAGE, 0.0d), 100.0d);
        if (r25 == null) goto L26;
        r24 = String.format(Locale.getDefault(), "%s %s (%.1f%%)", new Object[]{UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_current_file_text), r25, Double.valueOf(r26)});
        goto L25
    L21:
        if (r10.equals(UploadWorker.KEY_PROGRESS_DATA_TYPE_COMPRESSION) == false) goto L26;
        double r27 = r8.b(UploadWorker.KEY_PROGRESS_COMPRESSION_PERCENTAGE, 0.0d);
        if (r27 <= 0.0d) goto L26;
        r24 = String.format(Locale.getDefault(), "%s %.1f%%", new Object[]{UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_compress_file_progress_text), Double.valueOf(r27)});
        goto L25
    }

    public static /* synthetic */ void m(CompanySceneCollectActivity r8, View r10) {
        r8.lambda$setupButtons$3(r10);
    }

    public static /* synthetic */ void n(CompanySceneCollectActivity r8, View r10) {
        r8.lambda$setupButtons$4(r10);
    }

    public static /* synthetic */ void o(CompanySceneCollectActivity r8, CompoundButton r10, boolean r11) {
        r8.lambda$setupSceneSelection$2(r10, r11);
    }

    public static /* synthetic */ void p(CompanySceneCollectActivity r8, View r10) {
        r8.lambda$onCreate$1(r10);
    }

    public static /* synthetic */ void q(CompanySceneCollectActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showPreCollectDialog$7(r10, r11);
    }

    public static /* synthetic */ void r(CompanySceneCollectActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showEndConfirmDialog$21(r10, r11);
    }

    private void recordTag(String r8) {
        Log.i("CompanyScene", "Tag clicked: " + r8);
        String r10 = "ts=" + System.currentTimeMillis() + " | tag=" + r8 + " | scene=" + sceneDesc(this.currentScene);
        File r11 = this.currentSessionDir;
        if (r11 != null) goto L5;
    L6:
        String r12 = UserAwareManager.getInstance().getSessionDir();
        if (r12 == null) goto L9;
        r11 = new File(r12);
    L9:
        if (r11 != null) goto L11;
    L19:
        Toast.makeText(this, getString(R.string.debug_company_tag_need_start_collect), 0).show();
        return;
    L11:
        if (r11.exists() == false) goto L19;
        String r13 = this.sessionDescCached;
        if (r13 == null) goto L19;
        if (r13.isEmpty() == true) goto L19;
        CaeLog.addTimeLog(r10, new File(r11, android.aimedia.a.i(new StringBuilder(), this.sessionDescCached, ".txt")));
        return;
    L5:
        if (r11.exists() == true) goto L9;
        goto L6
    }

    private void renderTagsForScene(SceneType r8) {
        final int r10 = 0;
        this.tagContainer.setVisibility(0);
        View r11 = findViewById(R.id.layout_floor_container);
        if (r11 == null) goto L5;
        r11.setVisibility(0);
    L5:
        this.tagContainer.removeAllViews();
        int r12 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType[r8.ordinal()];
        final int r13 = 1;
        if (r12 == 1) goto L15;
        final int r14 = 2;
        if (r12 == 2) goto L15;
        if (r12 != 3) goto L12;
    L14:
        addTagItem(getString(R.string.debug_company_stand_up_title), getString(R.string.debug_company_stand_up_hint), new b(this, r13));
        addTagItem(getString(R.string.debug_company_leave_home_gate_title), getString(R.string.debug_company_leave_home_gate_hint), new c(this, r13));
        addStairStartItem(false);
        addTagItem(getString(R.string.debug_company_down_finish_title), getString(R.string.debug_company_down_finish_hint), new m(this, r14));
        addTagItem(getString(R.string.debug_company_leave_building_title), getString(R.string.debug_company_leave_building_hint), new b(this, r14));
        return;
    L12:
        if (r12 == 4) goto L14;
        return;
    L15:
        addTagItem(getString(R.string.debug_company_enter_building_title), getString(R.string.debug_company_enter_building_hint), new m(this, r10));
        addStairStartItem(true);
        addTagItem(getString(R.string.debug_company_up_finish_title), getString(R.string.debug_company_up_finish_hint), new b(this, r10));
        addTagItem(getString(R.string.debug_company_enter_floor_gate_title), getString(R.string.debug_company_enter_floor_gate_hint), new c(this, r10));
        addTagItem(getString(R.string.debug_company_sit_down_title), getString(R.string.debug_company_sit_down_hint), new m(this, r13));
    }

    public static /* synthetic */ void s(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$10();
    }

    private String sceneDesc(SceneType r8) {
        if (r8 != null) goto L5;
        return "";
    L5:
        int r10 = AnonymousClass1.$SwitchMap$com$obric$cae$userAware$ui$CompanySceneCollectActivity$SceneType[r8.ordinal()];
        if (r10 != 1) goto L8;
        int r11 = R.string.debug_scene_home_arrive;
    L16:
        return getString(r11);
    L8:
        if (r10 != 2) goto L10;
        r11 = R.string.debug_scene_company_arrive;
        goto L16
    L10:
        if (r10 != 3) goto L12;
        r11 = R.string.debug_scene_home_leave;
        goto L16
    L12:
        if (r10 == 4) goto L14;
        return "";
    L14:
        r11 = R.string.debug_scene_company_leave;
        goto L16
    }

    private void selectScene(SceneType r8) {
        this.currentScene = r8;
        boolean r10 = true;
        this.mUpdatingSelection = true;
        RadioButton r11 = this.rbHomeArrive;
        if (r8 != SceneType.HOME_ARRIVE) goto L5;
        boolean r12 = true;
    L6:
        r11.setChecked(r12);
        RadioButton r13 = this.rbCompanyArrive;
        if (r8 != SceneType.COMPANY_ARRIVE) goto L9;
        boolean r14 = true;
    L10:
        r13.setChecked(r14);
        RadioButton r15 = this.rbHomeLeave;
        if (r8 != SceneType.HOME_LEAVE) goto L13;
        boolean r16 = true;
    L14:
        r15.setChecked(r16);
        RadioButton r17 = this.rbCompanyLeave;
        if (r8 == SceneType.COMPANY_LEAVE) goto L18;
        r10 = false;
    L18:
        r17.setChecked(r10);
        this.mUpdatingSelection = false;
        renderTagsForScene(this.currentScene);
        updateTagSubtitle(this.currentScene);
        return;
    L13:
        r16 = false;
        goto L14
    L9:
        r14 = false;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    private void setupButtons() {
        this.btnStart.setOnClickListener(new g(this, 0));
        this.btnEnd.setOnClickListener(new com.google.android.material.search.a(this, 4));
    }

    private void setupSceneSelection() {
        f r8 = new f(this, 0);
        this.rbHomeArrive.setOnCheckedChangeListener(r8);
        this.rbCompanyArrive.setOnCheckedChangeListener(r8);
        this.rbHomeLeave.setOnCheckedChangeListener(r8);
        this.rbCompanyLeave.setOnCheckedChangeListener(r8);
    }

    private void showEndConfirmDialog() {
        AlertDialog.Builder r8 = new AlertDialog.Builder(this);
        r8.setTitle(getString(R.string.debug_company_end_collect_title));
        r8.setMessage(getString(R.string.debug_company_end_collect_message));
        int r10 = 1;
        r8.setPositiveButton(getString(R.string.debug_company_end_collect_positive), new h(this, r10));
        r8.setNegativeButton(getString(R.string.debug_company_cancel), new i(r10));
        r8.setNeutralButton(getString(R.string.debug_company_discard), new j(this, r10));
        r8.show();
    }

    private void showPreCollectDialog() {
        int r8 = 0;
        if (androidx.core.content.a.a(this, "android.permission.RECORD_AUDIO") != 0) goto L5;
        boolean r10 = true;
    L6:
        AlertDialog.Builder r11 = new AlertDialog.Builder(this);
        r11.setTitle(getString(R.string.debug_company_pre_collect_title));
        r11.setMessage(getString(R.string.debug_company_pre_collect_message));
        r11.setPositiveButton(getString(R.string.debug_company_pre_collect_positive), new h(this, r8));
        r11.setNegativeButton(getString(R.string.debug_company_cancel), new i(r8));
        if (r10 == true) goto L9;
        r11.setNeutralButton(getString(R.string.debug_company_go_settings), new j(this, r8));
    L9:
        r11.show();
        return;
    L5:
        r10 = false;
        goto L6
    }

    private void showStairTypeDialog(final boolean r8, final TextView r10) {
        final String[] r11 = {getString(R.string.debug_company_type_elevator), getString(R.string.debug_company_type_escalator), getString(R.string.debug_company_type_stairs)};
        AlertDialog.Builder r12 = new AlertDialog.Builder(this);
        r12.setTitle(getString(R.string.debug_company_choose_type_title));
        r12.setSingleChoiceItems(r11, -1, new l(this, r10, r11, r8));
        r12.show();
    }

    private void startCollect() {
        this.state = CollectState.COLLECTING;
        this.btnStart.setEnabled(false);
        this.btnStart.setText(getString(R.string.debug_company_collecting_text));
        this.btnEnd.setVisibility(0);
        this.rbHomeArrive.setEnabled(false);
        this.rbCompanyArrive.setEnabled(false);
        this.rbHomeLeave.setEnabled(false);
        this.rbCompanyLeave.setEnabled(false);
        this.rbHomeArrive.setClickable(false);
        this.rbCompanyArrive.setClickable(false);
        this.rbHomeLeave.setClickable(false);
        this.rbCompanyLeave.setClickable(false);
        this.rbHomeArrive.setAlpha(0.5f);
        this.rbCompanyArrive.setAlpha(0.5f);
        this.rbHomeLeave.setAlpha(0.5f);
        this.rbCompanyLeave.setAlpha(0.5f);
        String r8 = sceneDesc(this.currentScene);
        UserAwareManager.getInstance().recordNearbyInfo(this, true, r8, COLLECT_TIMEOUT_MS, 61423);
        this.currentSessionDir = new File(UserAwareManager.getInstance().getSessionDir());
        this.sessionDescCached = r8;
        CaeLog.i("CompanyScene", "currentSessionDir = " + this.currentSessionDir);
        renderTagsForScene(this.currentScene);
    }

    private void startUploadBasic() {
        ensureWorkManagerInitialized();
        if (this.state != CollectState.COLLECTING) goto L7;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_stop_collect));
        return;
    L7:
        if (UserAwareUtil.isWifiConnectedAndValidated(getApplicationContext()) == true) goto L10;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_prompt_connect_wifi));
        return;
    L10:
        File r8 = UserAwareUtil.getNearbyLogPathFile(getApplicationContext());
        CaeLog.i("CompanyScene", "Upload from dir: " + r8.getAbsolutePath());
        ArrayList r10 = new ArrayList();
        UserAwareUtil.findFilesRecursively(r8, r10);
        if (r10.isEmpty() == false) goto L14;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_no_need_to_upload));
        return;
    L14:
        String r11 = FileController.getInstance(this).startOneTimeUpload();
        if (r11 != null) goto L18;
        CaeUtil.showShortToast(this, UserAwareUtil.getStringValueFromXML(getApplication(), R.string.user_aware_upload_work_not_start));
        return;
    L18:
        this.uploadWorkerId = UUID.fromString(r11);
        CaeUtil.showShortToast(this, getString(R.string.user_aware_uploading_title));
        LiveData<androidx.work.u> r12 = this.workInfoLiveData;
        if (r12 == null) goto L23;
        androidx.lifecycle.u<androidx.work.u> r13 = this.workInfoObserver;
        if (r13 == null) goto L23;
        r12.h(r13);
    L23:
        this.workInfoObserver = new e(this);
        androidx.lifecycle.r r14 = j1.b0.f(this).g(this.uploadWorkerId);
        this.workInfoLiveData = r14;
        r14.d(this.workInfoObserver);
    }

    private void stopCollect() {
        stopCollectInternal(false);
    }

    private void stopCollectInternal(boolean r11) {
        this.state = CollectState.IDLE;
        boolean r8 = true;
        this.btnStart.setEnabled(true);
        this.btnStart.setText(getString(R.string.debug_company_start_collect_text));
        this.btnEnd.setVisibility(8);
        this.rbHomeArrive.setEnabled(true);
        this.rbCompanyArrive.setEnabled(true);
        this.rbHomeLeave.setEnabled(true);
        this.rbCompanyLeave.setEnabled(true);
        this.rbHomeArrive.setClickable(true);
        this.rbCompanyArrive.setClickable(true);
        this.rbHomeLeave.setClickable(true);
        this.rbCompanyLeave.setClickable(true);
        this.rbHomeArrive.setAlpha(1.0f);
        this.rbCompanyArrive.setAlpha(1.0f);
        this.rbHomeLeave.setAlpha(1.0f);
        this.rbCompanyLeave.setAlpha(1.0f);
        if (r11 == true) goto L21;
        EditText r10 = this.etFloor;
        if (r10 == null) goto L21;
        Editable r12 = r10.getText();
        if (r12 == null) goto L9;
        String r13 = r12.toString().trim();
    L11:
        if (r13.isEmpty() == true) goto L21;
        int r14 = 0;
    L14:
        if (r14 >= r13.length()) goto L19;
        if (Character.isDigit(r13.charAt(r14)) == false) goto L17;
        r14 = r14 + 1;
        goto L14
    L17:
        r8 = false;
    L19:
        if (r8 == false) goto L21;
        recordTag("floor:".concat(r13));
        goto L21
    L9:
        r13 = "";
    L21:
        UserAwareManager.getInstance().recordNearbyInfo(this, false, null, 0, 0);
        this.tagContainer.setVisibility(8);
        View r15 = findViewById(R.id.layout_floor_container);
        if (r15 == null) goto L24;
        r15.setVisibility(8);
    L24:
        this.tagContainer.removeAllViews();
        this.rbHomeArrive.setChecked(false);
        this.rbCompanyArrive.setChecked(false);
        this.rbHomeLeave.setChecked(false);
        this.rbCompanyLeave.setChecked(false);
        this.currentScene = null;
        TextView r16 = this.tvTagSubtitle;
        if (r16 == null) goto L27;
        r16.setText("");
    L27:
        if (r11 == true) goto L32;
        CaeUtil.showShortToast(this, getString(R.string.debug_company_upload_later_toast));
        return;
    }

    public static /* synthetic */ void t(CompanySceneCollectActivity r8, Runnable r10, View r11, TextView r12, TextView r13, View r14) {
        r8.lambda$addTagItem$16(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ void u(CompanySceneCollectActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showEndConfirmDialog$19(r10, r11);
    }

    private void updateTagSubtitle(SceneType r8) {
        TextView r10 = this.tvTagSubtitle;
        if (r10 != null) goto L5;
        return;
    L5:
        r10.setText(getString(R.string.debug_company_tag_subtitle));
    }

    public static /* synthetic */ void v(CompanySceneCollectActivity r8, androidx.work.u r10) {
        r8.lambda$startUploadBasic$22(r10);
    }

    public static /* synthetic */ void w(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$8();
    }

    public static /* synthetic */ void x(CompanySceneCollectActivity r8) {
        r8.lambda$renderTagsForScene$13();
    }

    public static /* synthetic */ void y(DialogInterface r8, int r10) {
        lambda$showEndConfirmDialog$20(r8, r10);
    }

    public static /* synthetic */ void z(CompanySceneCollectActivity r8, boolean r10, TextView r11, View r12, TextView r13, View r14) {
        r8.lambda$addStairStartItem$17(r10, r11, r12, r13, r14);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (this.state != CollectState.COLLECTING) goto L5;
        showEndConfirmDialog();
        return;
    L5:
        super.onBackPressed();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_company_scene_collect);
        ensureWorkManagerInitialized();
        OCTitleBar r10 = (OCTitleBar) findViewById(R.id.debug_company_scene_title);
        if (r10 == null) goto L7;
        OButton r11 = r10.getMLeftActionBack();
        if (r11 == null) goto L7;
        r11.setOnClickListener(new k(this, 0));
    L7:
        View r12 = findViewById(R.id.btn_upload);
        this.btnUpload = r12;
        if (r12 == null) goto L10;
        r12.setOnClickListener(new g(this, 1));
    L10:
        initViews();
        setupSceneSelection();
        setupButtons();
    }
}
