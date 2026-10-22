package com.ss.android.lark.chameleonv2.debug;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ss.android.lark.chameleon.ChameleonBizType;
import com.ss.android.lark.officesdk.utils.di.ThreadUtil;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f {
    public static final List<String> b = null;
    public static final Map<String, String> c = null;
    public static final Map<String, String> d = null;
    public static final Map<String, String> e = null;
    public w0b.a a;

    public static final class a {
    }

    public f() {
    }

    static {
        b = CollectionsKt.mutableListOf(new String[]{"doubao", "lark"});
        ChameleonBizType r0 = ChameleonBizType.BIZ_DOCS;
        c = MapsKt.mapOf(TuplesKt.to(r0.getType(), "https://tosv.byted.org/obj/bytedance-oss-bear-web-test/scm_zip/%s/android/docs_channel.zip"));
        d = MapsKt.mapOf(new Pair[]{TuplesKt.to(r0.getType(), "https://luban-source.byted.org/repository/scm/flow.mobile.office_%s.tar.gz"), TuplesKt.to(ChameleonBizType.BIZ_SLIDES.getType(), "https://luban-source.byted.org/repository/scm/flow.mobile.slides_%s.tar.gz")});
        e = MapsKt.mapOf(TuplesKt.to(r0.getType(), "https://tosv.byted.org/obj/bytedance-oss-bear-web-test/flow-mobile-office/scm_zip/%s/offline_pkg.zip"));
    }

    public static String b(String r10) {
        Intrinsics.checkNotNullParameter(r10, "url");
        MatchResult r11 = Regex.find$default(new Regex("\\b\\d+(?:[._]\\d+){3}\\b"), r10, 0, 2, null);
        if (r11 == null) goto L8;
        String r4 = r11.getValue();
        if (r4 != null) goto L7;
        return null;
    L7:
        return StringsKt.replace$default(r4, '_', '.', false, 4, null);
    L8:
        return null;
    }

    public static final void a(f r0, Context r1, String r2) {
        r0.getClass();
        Lazy r3 = ThreadUtil.a;
        ThreadUtil.a.g(new q(r1, r2));
    }

    public final void d(ChameleonDebugActivity r15, boolean r16, Function0 r17) {
        Intrinsics.checkNotNullParameter(r15, "context");
        LinearLayout r0 = new LinearLayout(r15);
        boolean r1 = true;
        r0.setOrientation(1);
        r0.setPadding(32, 16, 32, 16);
        String r2 = CmlDebugSettingUtil.a("chameleon_specific_bizname", BuildConfig.FLAVOR);
        if (r16 == false) goto L5;
        String r5 = "chameleon_specific_download_url_tos";
    L6:
        String r6 = CmlDebugSettingUtil.a(r5, BuildConfig.FLAVOR);
        TextView r4 = c(r15, CmlDebugSettingUtil.a("chameleon_app_name", BuildConfig.FLAVOR), "请选择app", b, true);
        TextView r7 = new TextView(r15);
        r7.setText("bizName");
        ChameleonBizType[] r8 = ChameleonBizType.values();
        ArrayList r9 = new ArrayList(r8.length);
        int r10 = r8.length;
        int r12 = 0;
    L7:
        if (r12 >= r10) goto L9;
        r9.add(r8[r12].getType());
        r12 = r12 + 1;
        goto L7
    L9:
        TextView r3 = c(r15, r2, "请输入bizName", r9, false);
        TextView r11 = new TextView(r15);
        r11.setText("资源版本或URL");
        EditText r13 = new EditText(r15);
        if (r6.length() > 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L15;
        r13.setText(r6);
        r13.setSelection(r6.length());
    L16:
        r13.setPadding(16, 16, 16, 16);
        r0.addView(r4);
        r0.addView(r7);
        r0.addView(r3);
        r0.addView(r11);
        r0.addView(r13);
        new AlertDialog.Builder(r15).setTitle("下载并设置离线资源").setView(r0).setPositiveButton("保存", new m(r4, r3, r13, r16, this, r15, r17)).setNegativeButton("取消", null).show();
        return;
    L15:
        r13.setHint("请输入版本号或下载地址");
        goto L16
    L5:
        r5 = "chameleon_specific_download_url_scm";
        goto L6
    }

    public static TextView c(ChameleonDebugActivity r2, String r3, String r4, List r5, boolean r6) {
        ArrayAdapter r0 = new ArrayAdapter(r2, R.layout.simple_dropdown_item_1line, r5);
        AutoCompleteTextView r7 = new AutoCompleteTextView(r2);
        if (r6 == false) goto L6;
        r7.setKeyListener(null);
        r7.setFocusable(false);
        r7.setFocusableInTouchMode(false);
    L6:
        if (r3.length() != 0) goto L8;
        boolean r8 = true;
    L9:
        if (r8 == true) goto L11;
        r7.setText(r3);
        r7.setSelection(r3.length());
    L12:
        r7.setPadding(16, 16, 16, 16);
        r7.setAdapter(r0);
        r7.setOnFocusChangeListener(new h(r7));
        r7.setOnClickListener(new i(r7));
        r7.setThreshold(0);
        return r7;
    L11:
        r7.setHint(r4);
        goto L12
    L8:
        r8 = false;
        goto L9
    }
}
