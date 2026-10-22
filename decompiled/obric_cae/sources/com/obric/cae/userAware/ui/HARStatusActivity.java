package com.obric.cae.userAware.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.obric.cae.R;
import com.obric.cae.log.CaeLog;
import com.obric.cae.userAware.datacollection.AwareStateListener;
import com.obric.cae.userAware.datacollection.FileController;
import com.obric.cae.userAware.datacollection.HARFeedbackInfo;
import com.obric.cae.userAware.db.HARRecordDatabase;
import com.obric.cae.userAware.report.CaeUserAwareReportBase;
import com.obric.cae.userAware.report.CaeUserAwareReportFactory;
import com.obric.cae.userAware.utils.UserAwareUtil;
import com.obric.oui.titlebar.OCTitleBar;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class HARStatusActivity extends androidx.appcompat.app.e {
    private static final int DELAY_FOR_UPLOAD_RAW_DATA_FILE = 30000;
    private static final String TAG = "HARStatusActivity";
    private HARRecordAdapter adapter;
    private List<HARFeedbackInfo> allRecords;
    private View bottomActionBar;
    private HARRecordDatabase database;
    private TextView dateFilterTextview;
    private TextView emptyStateText;
    private final List<HARFeedbackInfo> filteredRecords;
    private boolean isMultiSelectMode;
    private ListView listView;
    private Toast mToast;
    private String userSelectData;

    public HARStatusActivity() {
        this.allRecords = new ArrayList();
        this.filteredRecords = new ArrayList();
        this.isMultiSelectMode = false;
    }

    private void batchUpdate(boolean r8) {
        Set<Long> r10 = this.adapter.getSelectedRecordIds();
        CaeLog.d(TAG, "batchUpdate: selectedIds size: " + r10.size() + ", ids: " + r10);
        if (r10.isEmpty() == false) goto L6;
        showToast(getStringFromXML(R.string.user_aware_har_please_select_record));
        return;
    L6:
        new Thread(new j1.o(this, r10, r8, 1), "BatchUpdateThread").start();
    }

    public static /* synthetic */ void d(HARStatusActivity r8, View r10) {
        r8.lambda$onCreate$4(r10);
    }

    public static /* synthetic */ void e(HARStatusActivity r8, View r10) {
        r8.lambda$onCreate$1(r10);
    }

    private void exitMultiSelectMode() {
        this.isMultiSelectMode = false;
        this.bottomActionBar.setVisibility(8);
        this.adapter.setMultiSelectMode(false);
        invalidateOptionsMenu();
    }

    public static /* synthetic */ void f(HARStatusActivity r8, long r10, boolean r11) {
        r8.lambda$updateRecordFeedback$12(r10, r11);
    }

    private void filterRecordsByDate() {
        String r8 = this.dateFilterTextview.getText().toString().trim();
        if (r8.isEmpty() == false) goto L6;
        Toast.makeText(this, getStringFromXML(R.string.user_aware_har_please_select_date), 0).show();
        return;
    L6:
        this.userSelectData = r8;
        filterRecordsByDate(r8);
    }

    public static /* synthetic */ void g(HARStatusActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showDateDialog$15(r10, r11);
    }

    private String getStringFromXML(int r8) {
        return UserAwareUtil.getStringValueFromXML(this, r8);
    }

    public static /* synthetic */ void h(HARStatusActivity r8, View r10) {
        r8.lambda$onCreate$0(r10);
    }

    public static /* synthetic */ void i(HARStatusActivity r8, HARFeedbackInfo r10, DialogInterface r11, int r12) {
        r8.lambda$showFeedbackDialog$10(r10, r11, r12);
    }

    public static /* synthetic */ void j(HARStatusActivity r8) {
        r8.lambda$showClearDialog$18();
    }

    public static /* synthetic */ void k(HARStatusActivity r8, DatePicker r10, Calendar r11, DialogInterface r12, int r13) {
        r8.lambda$showDateDialog$17(r10, r11, r12, r13);
    }

    public static /* synthetic */ void l(HARStatusActivity r8, DialogInterface r10, int r11) {
        r8.lambda$showClearDialog$20(r10, r11);
    }

    private /* synthetic */ void lambda$batchUpdate$13(int r8) {
        if (r8 <= 0) goto L9;
        exitMultiSelectMode();
        String r10 = this.userSelectData;
        if (r10 == null) goto L6;
        filterRecordsByDate(r10);
    L7:
        showToast(getStringFromXML(R.string.user_aware_har_batch_update_success));
        return;
    L6:
        loadAllRecords();
        goto L7
    }

    private /* synthetic */ void lambda$batchUpdate$14(Set r8, boolean r10) {
        int r11 = this.database.batchUpdateFeedback(new ArrayList(r8), r10);
        reportUserFeedbackInfos(r8);
        runOnUiThread(new q(this, r11, 0));
    }

    private /* synthetic */ void lambda$filterRecordsByDate$7(List r8) {
        this.filteredRecords.clear();
        this.filteredRecords.addAll(r8);
        this.adapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private /* synthetic */ void lambda$filterRecordsByDate$8(String r8) {
        int r10 = 3;
        runOnUiThread(new f1(r10, this, this.database.getRecordsByDate(r8)));
    }

    private /* synthetic */ void lambda$loadAllRecords$5() {
        this.filteredRecords.clear();
        this.filteredRecords.addAll(this.allRecords);
        this.adapter.notifyDataSetChanged();
        updateEmptyState();
    }

    private /* synthetic */ void lambda$loadAllRecords$6() {
        this.allRecords = this.database.getAllRecords();
        runOnUiThread(new u(this, 1));
    }

    private /* synthetic */ void lambda$onCreate$0(View r8) {
        showDateDialog();
    }

    private /* synthetic */ void lambda$onCreate$1(View r8) {
        batchUpdate(true);
    }

    private /* synthetic */ void lambda$onCreate$2(View r8) {
        batchUpdate(false);
    }

    private /* synthetic */ void lambda$onCreate$3(View r8) {
        exitMultiSelectMode();
    }

    private /* synthetic */ void lambda$onCreate$4(View r8) {
        finish();
    }

    private /* synthetic */ void lambda$showClearDialog$18() {
        loadAllRecords();
        showToast(getStringFromXML(R.string.user_aware_har_clear_success));
    }

    private /* synthetic */ void lambda$showClearDialog$19() {
        this.database.deleteAllRecords();
        runOnUiThread(new u(this, 0));
    }

    private /* synthetic */ void lambda$showClearDialog$20(DialogInterface r8, int r10) {
        new Thread(new u(this, 2), "showClearDialogThread").start();
    }

    private /* synthetic */ void lambda$showDateDialog$15(DialogInterface r8, int r10) {
        this.dateFilterTextview.setText(getStringFromXML(R.string.user_aware_har_all_dates));
        loadAllRecords();
    }

    private static /* synthetic */ void lambda$showDateDialog$16(DialogInterface r8, int r10) {
        r8.dismiss();
    }

    private /* synthetic */ void lambda$showDateDialog$17(DatePicker r8, Calendar r10, DialogInterface r11, int r12) {
        r10.set(r8.getYear(), r8.getMonth(), r8.getDayOfMonth());
        this.dateFilterTextview.setText(new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(r10.getTime()));
        CaeLog.d(TAG, "selected date:" + r10.getTime());
        filterRecordsByDate();
    }

    private /* synthetic */ void lambda$showFeedbackDialog$10(HARFeedbackInfo r8, DialogInterface r10, int r11) {
        updateRecordFeedback(r8.getId(), false);
    }

    private /* synthetic */ void lambda$showFeedbackDialog$9(HARFeedbackInfo r8, DialogInterface r10, int r11) {
        updateRecordFeedback(r8.getId(), true);
    }

    private /* synthetic */ void lambda$updateRecordFeedback$11(int r8) {
        if (r8 <= 0) goto L9;
        String r10 = this.userSelectData;
        if (r10 == null) goto L6;
        filterRecordsByDate(r10);
    L7:
        showToast(getStringFromXML(R.string.user_aware_har_feedback_updated));
        return;
    L6:
        loadAllRecords();
        goto L7
    }

    private /* synthetic */ void lambda$updateRecordFeedback$12(long r8, boolean r10) {
        int r11 = this.database.updateRecordFeedback(r8, r10);
        reportUserFeedbackInfo(r8);
        runOnUiThread(new q(this, r11, 1));
    }

    private void loadAllRecords() {
        new Thread(new c0(this, 3), "LoadAllRecordsThread").start();
    }

    public static /* synthetic */ void m(HARStatusActivity r8, int r10) {
        r8.lambda$updateRecordFeedback$11(r10);
    }

    public static /* synthetic */ void n(HARStatusActivity r8, String r10) {
        r8.lambda$filterRecordsByDate$8(r10);
    }

    public static /* synthetic */ void o(DialogInterface r8, int r10) {
        lambda$showDateDialog$16(r8, r10);
    }

    public static /* synthetic */ void p(HARStatusActivity r8, View r10) {
        r8.lambda$onCreate$2(r10);
    }

    public static /* synthetic */ void q(HARStatusActivity r8, HARFeedbackInfo r10, DialogInterface r11, int r12) {
        r8.lambda$showFeedbackDialog$9(r10, r11, r12);
    }

    public static /* synthetic */ void r(HARStatusActivity r8, View r10) {
        r8.lambda$onCreate$3(r10);
    }

    private void reportUserFeedbackInfo(long r8) {
        HARFeedbackInfo r10 = this.database.getRecordById(r8);
        if (r10 == null) goto L13;
        CaeLog.d(TAG, "reportFeedbackToServer record:" + r10);
        CaeUserAwareReportBase r11 = CaeUserAwareReportFactory.getReportInstance();
        if (r11 == null) goto L7;
        r11.reportHARFeedbackInfo(r10);
    L7:
        FileController r12 = FileController.getInstance(this);
        if (r12.isOneTimeTaskRunning() == false) goto L10;
        return;
    L10:
        if (r10.getUserChoice() != 0) goto L15;
        androidx.work.o r13 = r12.createOneTimeUploadWorkRequest(30000);
        j1.b0 r14 = j1.b0.f(getApplicationContext());
        r14.getClass();
        r14.e(Collections.singletonList(r13));
        return;
    L15:
        return;
    }

    private void reportUserFeedbackInfos(Set<Long> r8) {
        Iterator<Long> r10 = r8.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        reportUserFeedbackInfo(r10.next().longValue());
        goto L4
    }

    public static /* synthetic */ void s(HARStatusActivity r8, Set r10, boolean r11) {
        r8.lambda$batchUpdate$14(r10, r11);
    }

    private void selectAllUnfeedback() {
        HashSet r8 = new HashSet();
        Iterator<HARFeedbackInfo> r10 = this.filteredRecords.iterator();
    L4:
        if (r10.hasNext() == false) goto L8;
        HARFeedbackInfo r11 = r10.next();
        if (r11.getHasFeedback() == true) goto L4;
        r8.add(Long.valueOf(r11.getId()));
        goto L4
    L8:
        this.adapter.setSelectedRecords(r8);
    }

    private void showClearDialog() {
        new AlertDialog.Builder(this).setTitle(getStringFromXML(R.string.user_aware_har_clear_tile)).setMessage(getStringFromXML(R.string.user_aware_har_clear_confirm)).setPositiveButton(getStringFromXML(R.string.user_aware_har_confirm), new r(this, 1)).setNegativeButton(getStringFromXML(R.string.user_aware_har_cancel), null).show();
    }

    private void showDateDialog() {
        Calendar r8 = Calendar.getInstance();
        int r10 = r8.get(1);
        int r11 = r8.get(2);
        int r12 = r8.get(5);
        DatePicker r13 = new DatePicker(this);
        r13.init(r10, r11, r12, null);
        AlertDialog.Builder r14 = new AlertDialog.Builder(this);
        r14.setTitle(getStringFromXML(R.string.user_aware_har_select_date));
        r14.setView(r13);
        int r15 = 0;
        r14.setNeutralButton(getStringFromXML(R.string.user_aware_har_all_dates), new r(this, r15));
        r14.setNegativeButton(getStringFromXML(R.string.user_aware_har_cancel), new s(r15));
        r14.setPositiveButton(getStringFromXML(R.string.user_aware_har_confirm), new t(this, r13, r8, r15));
        r14.show();
    }

    private void showToast(String r8) {
        Toast r10 = this.mToast;
        if (r10 == null) goto L5;
        r10.cancel();
    L5:
        Toast r11 = Toast.makeText(this, r8, 0);
        this.mToast = r11;
        r11.show();
    }

    public static /* synthetic */ void t(HARStatusActivity r8, List r10) {
        r8.lambda$filterRecordsByDate$7(r10);
    }

    public static /* synthetic */ void u(HARStatusActivity r8, int r10) {
        r8.lambda$batchUpdate$13(r10);
    }

    private void updateEmptyState() {
        if (this.filteredRecords.isEmpty() == false) goto L5;
        this.emptyStateText.setVisibility(0);
        this.listView.setVisibility(8);
        return;
    L5:
        this.emptyStateText.setVisibility(8);
        this.listView.setVisibility(0);
    }

    private void updateRecordFeedback(final long r8, final boolean r10) {
        new Thread(new z(this, r8, r10), "UpdateRecordFeedbackThread").start();
    }

    public static /* synthetic */ void v(HARStatusActivity r8) {
        r8.lambda$loadAllRecords$5();
    }

    public static /* synthetic */ void w(HARStatusActivity r8) {
        r8.lambda$showClearDialog$19();
    }

    public static /* synthetic */ void x(HARStatusActivity r8) {
        r8.lambda$loadAllRecords$6();
    }

    public void enterMultiSelectMode() {
        this.isMultiSelectMode = true;
        this.bottomActionBar.setVisibility(0);
        this.adapter.setMultiSelectMode(true);
        invalidateOptionsMenu();
    }

    @Override // androidx.fragment.app.m, androidx.activity.ComponentActivity, androidx.core.app.e, android.app.Activity
    public void onCreate(Bundle r8) {
        super.onCreate(r8);
        setContentView(R.layout.activity_records);
        String r10 = TAG;
        CaeLog.d(r10, "onCreate");
        TextView r11 = (TextView) findViewById(R.id.date_filter_textview);
        this.dateFilterTextview = r11;
        r11.setText(getStringFromXML(R.string.user_aware_har_all_dates));
        this.listView = (ListView) findViewById(R.id.list_view);
        this.bottomActionBar = findViewById(R.id.bottom_action_bar);
        this.emptyStateText = (TextView) findViewById(R.id.empty_state_text);
        this.database = new HARRecordDatabase(this);
        HARRecordAdapter r12 = new HARRecordAdapter(this, this.filteredRecords);
        this.adapter = r12;
        this.listView.setAdapter(r12);
        final int r13 = 0;
        findViewById(R.id.date_filter_textview).setOnClickListener(new x(this, r13));
        findViewById(R.id.btn_correct).setOnClickListener(new y(this, r13));
        findViewById(R.id.btn_incorrect).setOnClickListener(new k(this, 2));
        final int r14 = 1;
        findViewById(R.id.btn_cancel).setOnClickListener(new x(this, r14));
        OCTitleBar r15 = (OCTitleBar) findViewById(R.id.har_current_title);
        int r16 = Settings.Global.getInt(getContentResolver(), AwareStateListener.SETTINGS_GLOBAL_HAR_STATE, -1);
        defpackage.b.m("harState is :", r16, r10);
        if (r15 == null) goto L5;
        r15.setTitleText(getResources().getString(R.string.user_aware_scenario_current) + UserAwareUtil.getHarStateString(this, r16));
        r15.getMLeftActionBack().setOnClickListener(new y(this, r14));
    L5:
        loadAllRecords();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu r8) {
        getMenuInflater().inflate(R.menu.record_menu, r8);
        return true;
    }

    @Override // androidx.appcompat.app.e, androidx.fragment.app.m, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.database.close();
        this.userSelectData = null;
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem r8) {
        int r10 = r8.getItemId();
        if (r10 != R.id.action_select_all) goto L7;
        selectAllUnfeedback();
        return true;
    L7:
        if (r10 != R.id.action_clear_all) goto L11;
        showClearDialog();
        return true;
    L11:
        return super.onOptionsItemSelected(r8);
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu r8) {
        r8.findItem(R.id.action_select_all).setVisible(this.isMultiSelectMode);
        return true;
    }

    public void showFeedbackDialog(final HARFeedbackInfo r8) {
        new AlertDialog.Builder(this).setTitle(getStringFromXML(R.string.user_aware_har_status) + UserAwareUtil.getHarStateString(this, r8.getStateCode()) + getStringFromXML(R.string.user_aware_har_user_select)).setPositiveButton(getStringFromXML(R.string.user_aware_har_select_true), new v(this, r8)).setNegativeButton(getStringFromXML(R.string.user_aware_har_select_false), new w(this, r8, 0)).show();
    }

    private void filterRecordsByDate(String r8) {
        new Thread(new f1(2, this, r8), "FilterRecordsThread").start();
    }
}
