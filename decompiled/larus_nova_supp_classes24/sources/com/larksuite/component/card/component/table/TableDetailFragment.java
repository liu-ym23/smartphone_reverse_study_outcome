package com.larksuite.component.card.component.table;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larksuite.component.card.cardcontainer.UniversalCardRuntimeJsLoader;
import com.larksuite.component.card.cardcontainer.c;
import com.larksuite.component.card.component.CardResourceProvider;
import com.larksuite.component.card.utils.k;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.TemplateBundle;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.insets.f;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00072\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J,\u0010\u001a\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u001b\u001a\u00020\u0010H\u0002J\u001a\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larksuite/component/card/component/table/TableDetailFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "lynxContainer", "Lcom/ss/android/lark/lynxkit/container/ILarkLynxContainer;", "lynxView", "Landroid/view/View;", "fromForseti", "", "globalData", "", "initData", "shareData", "Lcom/larksuite/component/card/cardcontainer/UniversalCardShareData;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "putArguments", "renderCard", "buildContainer", "context", "Landroid/content/Context;", "getDebugUrl", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class TableDetailFragment extends BaseFragment {
    public ILarkLynxContainer d;
    public View e;
    public String f;
    public String g;
    public c h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ TableDetailFragment a;

        public b(TableDetailFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
            zab.a.a(this.a);
        }
    }

    static {
    }

    public TableDetailFragment() {
    }

    public final void onCreate(Bundle r5) {
        super.onCreate(r5);
        Context r6 = getContext();
        if (r6 == null) goto L12;
        Activity r7 = UIUtils.getActivityFromContext(r6);
        if (r7 == null) goto L12;
        String r0 = this.f;
        com.larksuite.component.card.cardcontainer.a r1 = new com.larksuite.component.card.cardcontainer.a();
        vy7.a r2 = new vy7.a();
        LarkLynxContainerBuilder r8 = new LarkLynxContainerBuilder(r7).tagForJsContext("UniversalCard").tagForCustomComponent("UniversalCard").containerContext(r1).tagForBridgeMethodDispatcher("UniversalCard");
        r8.lynxViewLifeCycle(r2);
        ILarkLynxContainer r9 = r8.setEnableUserCodeCache(true).setResourceProvider("EXTERNAL_JS_SOURCE", new CardResourceProvider()).setCodeCacheSourceUrl("local://open_card").build();
        this.d = r9;
        View r3 = r9.getLynxView();
        if (r0 == null) goto L10;
        r9.updateGlobalData(r0);
    L10:
        r3.setFocusable(false);
        this.e = r3;
        return;
    L12:
        Log.e("TableDetailFragment", "onCreate getContext is null");
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super.onViewCreated(r2, r3);
        f r4 = WindowInsetsUtils.b(this);
        r4.c(true);
        r4.o(true);
        r4.k(true);
        r4.r(true);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        View r7 = this.e;
        if (r7 != null) goto L6;
        return null;
    L6:
        View r8 = r4.inflate(2131564929, r5, false);
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup r9 = (ViewGroup) r8;
        ((ViewGroup) r9.findViewById(2131384822)).addView(r7);
        r9.findViewById(2131388807).setLeftClickListener(new b(this));
        String r10 = ty7.a.a().getDebugUrl();
        boolean r11 = DevEnvUtil.isDevelopPackage(LarkContext.getApplication());
        LinkedHashMap r0 = new LinkedHashMap();
        c r1 = this.h;
        if (r1 == null) goto L9;
        r0.put("card_share_data", r1);
    L9:
        r0.put("in_detail", Boolean.TRUE);
        String r2 = this.g;
        if (r11 == true) goto L12;
    L17:
        UniversalCardRuntimeJsLoader.b r12 = new UniversalCardRuntimeJsLoader().a();
        if (r12 == null) goto L25;
        TemplateBundle r13 = r12.c;
        if (r13 == null) goto L24;
        ILarkLynxContainer r14 = this.d;
        if (r14 == null) goto L25;
        r14.render(r13, r2, r0);
        goto L25
    L24:
        Log.e(((BaseFragment) this).PARENT_TAG, "js erro");
    L25:
        return r9;
    L12:
        if (k.b(r10) == false) goto L17;
        if (r10 == null) goto L25;
        ILarkLynxContainer r15 = this.d;
        if (r15 == null) goto L25;
        r15.render(r10, r2, r0);
        goto L25
    }
}
