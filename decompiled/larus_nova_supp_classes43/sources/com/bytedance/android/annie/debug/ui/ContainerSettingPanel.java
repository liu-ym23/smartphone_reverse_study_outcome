package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CompoundButton;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.debug.AnnieDebugTool;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import y9.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/annie/debug/ui/ContainerSettingPanel;", "Lcom/bytedance/android/annie/debug/ui/AbsInfoDialogFragment;", "<init>", "()V", "annie-debug_release"}, k = 1, mv = {1, 4, 3})
public final class ContainerSettingPanel extends AbsInfoDialogFragment {

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((u9.b) Annie.getService$default(u9.b.class, null, 2, null)).n0(r11);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ ContainerSettingPanel a;

        public b(ContainerSettingPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Context r11 = this.a.getContext();
            if (r11 == null) goto L6;
            a8.c.b(r11, new SettingEditFragment(), "container-setting");
            return;
        }
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public c(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class d implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public d(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class e implements View.OnClickListener {
        public final /* synthetic */ ContainerSettingPanel a;

        public e(ContainerSettingPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            ContainerSettingPanel r11 = this.a;
            Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
            ((u9.b) Annie.getService$default(u9.b.class, null, 2, null)).i1(r11.d);     // Catch: Throwable -> L5
            Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        L7:
            Result.exceptionOrNull-impl(r12);
            return;
        L5:
            th = move-exception;
            Result.Companion r1 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public static final class f implements View.OnClickListener {
        public final /* synthetic */ ContainerSettingPanel a;

        public f(ContainerSettingPanel r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            Intent r11 = new Intent();
            Context r0 = this.a.getContext();
            if (r0 == null) goto L5;
            String r1 = r0.getPackageName();
        L6:
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            r11.setClassName(r1, "com.bytedance.geckox.debugtool.ui.GeckoDebugMenuActivity");
            this.a.startActivity(r11);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    public static final class g implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public g(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class h implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public h(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class i implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public i(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class j implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public j(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class k implements CompoundButton.OnCheckedChangeListener {
        public static final k a = null;

        static {
            a = new k();
        }

        public k() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r1, boolean r10) {
            AnnieDebugTool r11 = AnnieDebugTool.a;
            AnnieDebugTool.b = r10;
        }
    }

    public static final class l implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public l(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    public static final class m implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ ContainerSettingPanel a;
        public final /* synthetic */ y9.i<Boolean> b;

        public m(ContainerSettingPanel r1, y9.i<Boolean> r10) {
            this.a = r1;
            this.b = r10;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r10, boolean r11) {
            ((o) Annie.getService$default(o.class, null, 2, null)).D0(this.a.getContext(), this.b.a, String.valueOf(r11), this.b.getType());
        }
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final String T90() {
        return "容器设置";
    }

    @Override // com.bytedance.android.annie.debug.ui.AbsInfoDialogFragment
    public final List<DialogItem> S90() {
        LinkedList r0 = new LinkedList();
        r0.add(new DialogItem("旧调试面板", "点我进入", new e(this)));
        r0.add(new DialogItem("GeckoX调试", "", new f(this)));
        y9.i<Boolean> r1 = AnnieConfigSettingKeys.JSB_ENABLE_PERMISSION_CHECK;
        r0.add(new DialogItem("容器鉴权", r1.a().booleanValue(), new g(this, r1)));
        y9.i<Boolean> r10 = AnnieConfigSettingKeys.FORCE_USE_FOREST;
        r0.add(new DialogItem("强制使用forest加载", r10.a().booleanValue(), new h(this, r10)));
        y9.i<Boolean> r11 = AnnieConfigSettingKeys.ADDING_ENV_TO_ALL_REQ;
        r0.add(new DialogItem("为所有请求加上Env Query参数", r11.a().booleanValue(), new i(this, r11)));
        y9.i<Boolean> r12 = AnnieConfigSettingKeys.HYBRID_LANDSCAPE_IS_FULLSCREEN;
        y9.i<Boolean> r13 = AnnieConfigSettingKeys.OFFLINE_SWITCH;
        r0.add(new DialogItem("离线化开关", r13.a().booleanValue(), new j(this, r13)));
        AnnieDebugTool r14 = AnnieDebugTool.a;
        if (AnnieDebugTool.b == false) goto L5;
        com.bytedance.ies.bullet.core.h.h.getClass();
        boolean r15 = true;
    L6:
        r0.add(new DialogItem("DebugTag", r15, k.a));
        y9.i<Boolean> r16 = AnnieConfigSettingKeys.STROKE_SWITCH;
        r0.add(new DialogItem("描边", r16.a().booleanValue(), new l(this, r16)));
        r0.add(new DialogItem("dialog容器横屏默认为全屏（Setting配置）", r12.a().booleanValue(), new m(this, r12)));
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L9
        Result.constructor-impl(Boolean.valueOf(r0.add(new DialogItem("LynxDevTool开关", ((u9.b) Annie.getService$default(u9.b.class, null, 2, null)).p0(), a.a))));     // Catch: Throwable -> L9
    L11:
        r0.add(new DialogItem("setting配置", null, new b(this)));
        y9.i<Boolean> r18 = AnnieConfigSettingKeys.OFFLINE_SWITCH;
        r0.add(new DialogItem("开启内存泄露检测并抛出异常", r18.a().booleanValue(), new c(this, r18)));
        y9.i<Boolean> r19 = AnnieConfigSettingKeys.METRIC_TIMING_SWITCH;
        r0.add(new DialogItem("Analytic 即时开关（即不退容器上报 pref 数据）", r19.a().booleanValue(), new d(this, r19)));
        return r0;
    L9:
        th = move-exception;
        Result.Companion r20 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L5:
        r15 = false;
        goto L6
    }

    public ContainerSettingPanel() {
    }
}
