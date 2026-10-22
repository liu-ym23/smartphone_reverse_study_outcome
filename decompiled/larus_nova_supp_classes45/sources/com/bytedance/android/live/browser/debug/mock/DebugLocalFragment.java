package com.bytedance.android.live.browser.debug.mock;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.api.SendLarkInterface;
import com.bytedance.android.live.core.monitor.LiveSlardarConstants;
import com.bytedance.android.live.core.setting.SettingUtil;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.network.response.Response;
import com.bytedance.android.livesdk.config.r8;
import com.bytedance.android.livesdkapi.TTLiveService;
import com.bytedance.android.livesdkapi.service.ILiveService;
import com.bytedance.mt.protector.impl.UriProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import org.json.JSONObject;
import q20.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/browser/debug/mock/DebugLocalFragment;", "Lcom/bytedance/android/live/browser/debug/mock/BaseDialogFragment;", "<init>", "()V", "a", "livehybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DebugLocalFragment extends BaseDialogFragment {
    public static final /* synthetic */ int e = 0;
    public Map<Integer, View> d;

    public static final class a {
    }

    public static final class b implements TextWatcher {
        public final /* synthetic */ DebugLocalFragment a;
        public final /* synthetic */ Uri b;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r1) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
        }

        public b(DebugLocalFragment r1, Uri r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r2, int r3, int r4, int r5) {
            EditText r6 = (EditText) this.a.S90(2131371416);
            int r7 = q20.a.a;
            String r8 = ((EditText) this.a.S90(2131371416)).getText().toString();
            Intrinsics.checkNotNullParameter(r8, "ipStr");
            if (new Regex("(http://)?([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+):\\d+").matches(r8) == false) goto L5;
            int r9 = 2131109391;
        L6:
            r6.setBackgroundResource(r9);
            Uri r11 = this.b;
            if (r11 == null) goto L9;
            this.a.T90(r11);
        L9:
            com.bytedance.android.livesdk.sharedpref.e r12 = com.bytedance.android.livesdk.sharedpref.b.x;
            String r13 = ((EditText) this.a.S90(2131371416)).getText().toString();
            r12.getClass();
            com.bytedance.android.livesdk.sharedpref.f.d(r12, r13);
            return;
        L5:
            r9 = 2131105622;
            goto L6
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ DebugLocalFragment a;

        public c(DebugLocalFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r6) {
            SettingUtil.updateLocal(r8.a, "true");
            Uri r7 = UriProtector.parse(((EditText) this.a.S90(2131368620)).getText().toString());
            ILiveService r0 = TTLiveService.getLiveService();
            if (r0 == null) goto L5;
            r0.handleSchema(this.a.getContext(), r7.buildUpon().appendQueryParameter("_not_start_virtual", GamePromoteDataContext.GAME_TYPE_MOBILE).build());
        L5:
            ((Map) com.bytedance.android.livesdk.sharedpref.b.z.getValue()).put(j.a(r7), r7.toString());
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ DebugLocalFragment a;

        public d(DebugLocalFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r11) {
            Uri r12 = UriProtector.parse(((EditText) this.a.S90(2131368620)).getText().toString());
            int r0 = q20.a.a;
            Context r1 = this.a.getContext();
            if (r1 == null) goto L14;
            String r2 = ((EditText) this.a.S90(2131362205)).getText().toString();
            Intrinsics.checkNotNullParameter(r12, "originSchema");
            StringBuilder r3 = new StringBuilder("adb shell am start -W -a android.intent.action.VIEW -d \"");
            Uri.Builder r13 = r12.buildUpon();
            if (r2 != null) goto L7;
        L12:
            Unit r4 = Unit.INSTANCE;
            r3.append(StringsKt.replace$default(r13.build().toString(), "&", "\\&", false, 4, null));
            r3.append('\"');
            q20.a.a(r1, r3.toString());
            return;
        L7:
            if (r2.length() <= 0) goto L9;
            boolean r5 = true;
        L10:
            if (r5 == false) goto L12;
            r13.scheme(r2);
            goto L12
        L9:
            r5 = false;
            goto L10
        }
    }

    public static final class e implements View.OnTouchListener {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            int r6 = r5.getAction();
            if (r6 == 0) goto L10;
            if (r6 != 1) goto L6;
            r4.getParent().requestDisallowInterceptTouchEvent(false);
        L11:
            return false;
        L6:
            if (r6 != 2) goto L11;
            r4.getParent().requestDisallowInterceptTouchEvent(true);
            goto L11
        L10:
            r4.getParent().requestDisallowInterceptTouchEvent(true);
            goto L11
        }
    }

    public static final class f implements View.OnTouchListener {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // android.view.View.OnTouchListener
        public final boolean onTouch(View r4, MotionEvent r5) {
            int r6 = r5.getAction();
            if (r6 == 0) goto L10;
            if (r6 != 1) goto L6;
            r4.getParent().requestDisallowInterceptTouchEvent(false);
        L11:
            return false;
        L6:
            if (r6 != 2) goto L11;
            r4.getParent().requestDisallowInterceptTouchEvent(true);
            goto L11
        L10:
            r4.getParent().requestDisallowInterceptTouchEvent(true);
            goto L11
        }
    }

    public static final class g implements View.OnClickListener {
        public final /* synthetic */ DebugLocalFragment a;

        public static final class a implements DialogInterface.OnClickListener {
            public final /* synthetic */ g a;
            public final /* synthetic */ EditText b;

            /* JADX INFO: renamed from: com.bytedance.android.live.browser.debug.mock.DebugLocalFragment$g$a$a, reason: collision with other inner class name */
            public static final class C0107a<T> implements Consumer {
                public final /* synthetic */ DialogInterface a;

                public C0107a(DialogInterface r1) {
                    this.a = r1;
                }

                public final void accept(Object r2) {
                    Response r3 = (Response) r2;
                    f2.c("发送成功", 0);
                    this.a.dismiss();
                }
            }

            public static final class b<T> implements Consumer {
                public final /* synthetic */ DialogInterface a;

                public b(DialogInterface r1) {
                    this.a = r1;
                }

                public final void accept(Object r1) {
                    Throwable r2 = (Throwable) r1;
                    this.a.dismiss();
                }
            }

            public a(g r1, EditText r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r3, int r4) {
                Intrinsics.checkNotNullParameter(r3, "dialog");
                if (this.b.getText().toString().length() != 0) goto L5;
                boolean r5 = true;
            L6:
                if (r5 == false) goto L9;
                f2.c("邮箱为空", 0);
                return;
            L9:
                JSONObject r6 = new JSONObject();
                r6.put("email", this.b.getText().toString());
                r6.put("msg", ((EditText) this.a.a.S90(2131368620)).getText().toString());
                r6.put("msg_title", "本地url");
                RequestBody r7 = RequestBody.create(MediaType.parse("Content-Type, application/json"), r6.toString());
                Observable<Response<Object>> r8 = ((SendLarkInterface) com.bytedance.android.live.network.c.b().e(SendLarkInterface.class)).postLarkMessage("https://cloudapi.bytedance.net/faas/services/tt41066dui1tz32x31/invoke/sendMessageToUser", r7);
                if (r8 == null) goto L17;
                Observable r9 = r8.subscribeOn(Schedulers.io());
                if (r9 == null) goto L18;
                Observable r11 = r9.observeOn(AndroidSchedulers.mainThread());
                if (r11 == null) goto L19;
                r11.subscribe(new C0107a(r3), new b(r3));
                return;
            L19:
                return;
            L18:
                return;
            L17:
                return;
            L5:
                r5 = false;
                goto L6
            }
        }

        public g(DebugLocalFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            EditText r0 = new EditText(r5.getContext());
            com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.r3;
            if (((CharSequence) r1.getValue()).length() <= 0) goto L5;
            boolean r2 = true;
        L6:
            if (r2 == false) goto L8;
            r0.setText((CharSequence) r1.getValue());
        L8:
            AlertDialog.Builder r3 = new AlertDialog.Builder(r5.getContext());
            r3.setTitle("输入邮箱前缀(yangxiaodong.06)").setView(r0).setNegativeButton("Cancel", null);
            r3.setPositiveButton("Ok", new a(this, r0));
            r3.show();
            return;
        L5:
            r2 = false;
            goto L6
        }
    }

    static {
    }

    public DebugLocalFragment() {
        this.d = new LinkedHashMap();
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.d).clear();
    }

    public final View S90(int r3) {
        if (this.d != null) goto L5;
        this.d = new LinkedHashMap();
    L5:
        View r0 = this.d.get(Integer.valueOf(r3));
        if (r0 != null) goto L14;
        View r1 = getView();
        if (r1 == null) goto L12;
        View r2 = r1.findViewById(r3);
        if (r2 == null) goto L12;
        this.d.put(Integer.valueOf(r3), r2);
        return r2;
    L12:
        return null;
    L14:
        return r0;
    }

    public final void T90(Uri r19) {
        Intrinsics.checkNotNullParameter(r19, "originUri");
        EditText r2 = (EditText) S90(2131368620);
        int r3 = q20.a.a;
        String r4 = ((EditText) S90(2131371416)).getText().toString();
        Intrinsics.checkNotNullParameter(r19, "originSchema");
        Intrinsics.checkNotNullParameter(r4, "ipStr");
        Intrinsics.checkNotNullParameter(r4, "ipStr");
        if (new Regex("(http://)?([0-9]+)\\.([0-9]+)\\.([0-9]+)\\.([0-9]+):\\d+").matches(r4) == true) goto L5;
        Uri r1 = Uri.EMPTY;
    L48:
        r2.setText(r1.toString());
        return;
    L5:
        Uri r5 = UriProtector.parse(UriProtector.getQueryParameter(r19, LiveSlardarConstants.EXTRA_KEY_URL));
        boolean r8 = false;
        if (StringsKt.startsWith$default(r4, "http://", false, 2, null) == true) goto L8;
        r4 = "http://".concat(r4);
    L8:
        Uri r6 = UriProtector.parse(r4);
        String r7 = r6.getPath();
        if (r7 != null) goto L11;
    L24:
        Uri.Builder r9 = r5.buildUpon();
        String r11 = r6.getScheme();
        if (r11 != null) goto L27;
    L32:
        String r12 = r6.getAuthority();
        if (r12 != null) goto L35;
    L40:
        String r13 = r6.getPath();
        if (r13 != null) goto L43;
    L47:
        Uri r14 = r9.build();
        int r15 = j.a;
        r1 = j.b(r19, r14.toString());
        goto L48
    L43:
        if (r13.length() <= 0) goto L45;
        r8 = true;
    L45:
        if (r8 == false) goto L47;
        r9.path(r13);
        goto L47
    L35:
        if (r12.length() <= 0) goto L37;
        boolean r16 = true;
    L38:
        if (r16 == false) goto L40;
        r9.encodedAuthority(r12);
        goto L40
    L37:
        r16 = false;
        goto L38
    L27:
        if (r11.length() <= 0) goto L29;
        boolean r17 = true;
    L30:
        if (r17 == false) goto L32;
        r9.scheme(r11);
        goto L32
    L29:
        r17 = false;
        goto L30
    L11:
        if (r7.length() != 0) goto L13;
        boolean r18 = true;
    L14:
        if (r18 != true) goto L24;
        Uri.Builder r21 = r6.buildUpon();
        String r22 = r5.getPath();
        if (r22 != null) goto L18;
        r22 = "";
    L18:
        Intrinsics.checkNotNullParameter(r22, "originPath");
        String r23 = r22;
        int r110 = StringsKt.indexOf$default(r23, "pages", 0, false, 6, null);
        int r24 = StringsKt.indexOf$default(r23, "template.js", 0, false, 6, null);
        if (r110 < 0) goto L22;
        if (r24 < 0) goto L22;
        r22 = "/dist/" + r22.substring(r110, r24) + "template.js";
    L23:
        r6 = r21.path(r22).build();
    L22:
        f2.g();
        goto L23
    L13:
        r18 = false;
        goto L14
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        Bundle r9 = getArguments();
        Object r11 = null;
        if (r9 == null) goto L5;
        Object r12 = r9.get("ARG_ORIGIN_URI");
    L7:
        if ((r12 instanceof Uri) == false) goto L10;
        r11 = r12;
    L10:
        Uri r13 = (Uri) r11;
        if (r13 == null) goto L13;
        ((TextView) S90(2131381678)).setText(r13.toString());
    L13:
        ((EditText) S90(2131371416)).addTextChangedListener(new b(this, r13));
        com.bytedance.android.livesdk.sharedpref.e r1 = com.bytedance.android.livesdk.sharedpref.b.x;
        String r2 = (String) r1.getValue();
        if (r2 != null) goto L16;
    L23:
        ((Button) S90(2131381505)).setOnClickListener(new c(this));
        Context r14 = getContext();
        if (r14 == null) goto L30;
        EditText r0 = (EditText) S90(2131362205);
        int r3 = q20.a.a;
        Intrinsics.checkNotNullParameter(r14, "context");
        String r4 = "sslocal";
        String r15 = (String) MapsKt.mapOf(new Pair[]{TuplesKt.to("com.bytedance.android.ttlivesdk_douyin", "snssdk1234"), TuplesKt.to("com.bytedance.android.ttlivesdk_dylite", "snssdk1234"), TuplesKt.to("com.bytedance.android.ttlivesdk_huoshan", "snssdk1234"), TuplesKt.to("com.bytedance.android.ttlivesdk_newhotsoon", "snssdk1234"), TuplesKt.to("com.ss.android.ugc.aweme", "sslocal")}).get(r14.getPackageName());
        if (r15 == null) goto L29;
        r4 = r15;
    L29:
        r0.setText(r4);
    L30:
        ((Button) S90(2131367950)).setOnClickListener(new d(this));
        ((TextView) S90(2131381678)).setOnTouchListener(e.a);
        ((EditText) S90(2131368620)).setOnTouchListener(f.a);
        ((Button) S90(2131385931)).setOnClickListener(new g(this));
        getBottomSheetSlideProcessor().disableDragDown();
        return;
    L16:
        if (r2.length() <= 0) goto L18;
        boolean r5 = true;
    L19:
        if (r5 != true) goto L23;
        ((EditText) S90(2131371416)).setText((CharSequence) r1.getValue());
        if (r13 == null) goto L23;
        T90(r13);
        goto L23
    L18:
        r5 = false;
        goto L19
    L5:
        r12 = null;
        goto L7
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131561185, r3, false);
    }
}
