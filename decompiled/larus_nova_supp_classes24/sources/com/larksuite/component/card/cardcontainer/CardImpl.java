package com.larksuite.component.card.cardcontainer;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.larksuite.component.card.component.CardResourceProvider;
import com.larksuite.component.card.debugger.ICardDebugger;
import com.larksuite.component.card.protocol.CardConfig;
import com.larksuite.component.card.protocol.CardContext;
import com.larksuite.component.card.protocol.CardData;
import com.larksuite.component.card.service.d;
import com.larksuite.component.card.utils.j;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larksuite.framework.utils.UIUtils;
import com.lynx.tasm.LynxView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.lynxkit.container.ILarkLynxContainer;
import com.ss.android.lark.lynxkit.container.LarkLynxContainerBuilder;
import com.ss.android.lark.utils.LarkContext;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J*\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J*\u0010\u0011\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J*\u0010$\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\u0010\u0003\u001a\u0004\u0018\u00010!H\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\u001a\u0010)\u001a\u0002H*\"\n\b\u0000\u0010*\u0018\u0001*\u00020\u0010H\u0082\b¢\u0006\u0002\u0010+J\b\u0010,\u001a\u00020\u001cH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006."}, d2 = {"Lcom/larksuite/component/card/cardcontainer/CardImpl;", "Lcom/larksuite/component/card/protocol/ICard;", "Landroidx/lifecycle/LifecycleObserver;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "cardConfig", "Lcom/larksuite/component/card/protocol/CardConfig;", "<init>", "(Landroidx/lifecycle/Lifecycle;Lcom/larksuite/component/card/protocol/CardConfig;)V", "destroyed", "", "universalCardRender", "Lcom/larksuite/component/card/cardcontainer/UniversalCardLynxRender;", "cardRenderByClass", "", "Ljava/lang/Class;", "Lcom/larksuite/component/card/cardcontainer/render/BaseCardRender;", "render", "getRender", "()Lcom/larksuite/component/card/cardcontainer/UniversalCardLynxRender;", "createView", "Landroid/view/View;", "context", "Landroid/content/Context;", "getLynxView", "Lcom/lynx/tasm/LynxView;", "createCardWidget", "Lcom/larksuite/component/card/cell/UniversalCardWidget;", "", "bizId", "", "cardContext", "Lcom/larksuite/component/card/protocol/CardContext;", "Lcom/larksuite/component/card/protocol/ICardLifeCycle;", "cardData", "Lcom/larksuite/component/card/protocol/CardData;", "renderEntity", "serverEntityJson", "cardRenderEntityConfig", "Lcom/larksuite/component/card/protocol/render/CardRenderEntityConfig;", "destroy", "acquireRender", "T", "()Lcom/larksuite/component/card/cardcontainer/render/BaseCardRender;", "onDestroy", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class CardImpl implements bz7.a, LifecycleObserver {
    public final CardConfig a;
    public boolean b;
    public final UniversalCardLynxRender c;
    public final Map<Class<? extends com.larksuite.component.card.cardcontainer.render.a>, com.larksuite.component.card.cardcontainer.render.a> d;

    public static final class a {
    }

    static {
    }

    @Override // bz7.a
    public final LynxView a() {
        ILarkLynxContainer r0 = this.c.a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r0 = null;
    L5:
        LynxView r1 = r0.getLynxView();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.lynx.tasm.LynxView");
        return r1;
    }

    public final void e() {
        if (this.b == false) goto L6;
        Log.w("CardImpl", "already destroyed");
        return;
    L6:
        Log.i("CardImpl", "destroy");
        Iterator r0 = ((LinkedHashMap) this.d).values().iterator();
    L8:
        if (r0.hasNext() == false) goto L10;
        ((com.larksuite.component.card.cardcontainer.render.a) r0.next()).a();
        goto L8
    L10:
        UniversalCardLynxRender r1 = this.c;
        ((d) r1.d.getValue()).destroy();
        ILarkLynxContainer r2 = r1.a;
        if (r2 == null) goto L13;
        r2.destroy();
    L13:
        this.b = true;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        Log.i("CardImpl", "destroy");
        e();
    }

    @Override // bz7.a
    public final UniversalCardLynxRender b() {
        return this.c;
    }

    public final View d(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        UniversalCardLynxRender r1 = this.c;
        CardConfig r2 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r2, "cardConfig");
        Activity r0 = UIUtils.getActivityFromContext(r7);
        if (r0 == null) goto L6;
        r7 = r0;
    L6:
        b r3 = r1.c;
        ((IUniversalCardJsService) LarkContext.spiByDwarf(IUniversalCardJsService.class)).initCardEnv(LarkContext.getApplication());
        LarkLynxContainerBuilder r4 = new LarkLynxContainerBuilder(r7).tagForCustomComponent("UniversalCard").containerContext(r1.b).tagForJsContext("UniversalCard").tagForBridgeMethodDispatcher("UniversalCard");
        if (r3 == null) goto L9;
        r4.lynxViewLifeCycle(r3);
    L9:
        Integer r5 = r2.getMaxWidth();
        if (r5 == null) goto L12;
        r5.intValue();
        Log.d("UniversalCardLynxRender", "lynxViewWidth : " + r2 + ".maxWidth");
        r4.widthMeasureSpec(View.MeasureSpec.makeMeasureSpec(r2.getMaxWidth().intValue(), 1073741824));
    L12:
        LarkLynxContainerBuilder r6 = r4.setResourceProvider("EXTERNAL_JS_SOURCE", new CardResourceProvider());
        ICardDebugger.a.getClass();
        ((ICardDebugger) ICardDebugger.Companion.b.getValue()).getEnable();
        ILarkLynxContainer r8 = r6.setEnableUserCodeCache(true).setCodeCacheSourceUrl("local://open_card").build();
        r1.a = r8;
        ILarkLynxContainer r9 = null;
        if (r8 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
        r8 = null;
    L15:
        View r10 = r8.getLynxView();
        ILarkLynxContainer r11 = r1.a;
        if (r11 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mLynxContainer");
    L19:
        r9.updateGlobalData(j.a(r2, r7));
        r10.setFocusable(false);
        return r10;
    L18:
        r9 = r11;
        goto L19
    }

    public CardImpl(Lifecycle r2, CardConfig r3) {
        Intrinsics.checkNotNullParameter(r3, "cardConfig");
        this.a = r3;
        this.c = new UniversalCardLynxRender(r2);
        this.d = new LinkedHashMap();
        if (r2 == null) goto L6;
        r2.addObserver(this);
        return;
    }

    @Override // bz7.a
    public final void c(CardData r7, CardContext r8, CardConfig r9) {
        Intrinsics.checkNotNullParameter(r7, "cardData");
        Intrinsics.checkNotNullParameter(r8, "cardContext");
        Intrinsics.checkNotNullParameter(r9, "cardConfig");
        com.larksuite.component.card.cardcontainer.render.a r3 = (com.larksuite.component.card.cardcontainer.render.a) ((LinkedHashMap) this.d).get(com.larksuite.component.card.cardcontainer.render.c.class);
        if (r3 == null) goto L6;
        com.larksuite.component.card.cardcontainer.render.c r4 = (com.larksuite.component.card.cardcontainer.render.c) r3;
    L15:
        Intrinsics.checkNotNullParameter(r7, "cardData");
        Intrinsics.checkNotNullParameter(r8, "cardContext");
        Intrinsics.checkNotNullParameter(r9, "cardConfig");
        r4.b(r7, r8, r9);
        return;
    L6:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.b.class) == false) goto L9;
        com.larksuite.component.card.cardcontainer.render.a r5 = new com.larksuite.component.card.cardcontainer.render.b(this.c, this.a);
    L14:
        this.d.put(com.larksuite.component.card.cardcontainer.render.c.class, r5);
        r4 = (com.larksuite.component.card.cardcontainer.render.c) r5;
        goto L15
    L9:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.c.class) == false) goto L12;
        r5 = new com.larksuite.component.card.cardcontainer.render.c(this.c, this.a);
        goto L14
    L12:
        if (Intrinsics.areEqual(com.larksuite.component.card.cardcontainer.render.c.class, com.larksuite.component.card.cardcontainer.render.d.class) == false) goto L18;
        r5 = new com.larksuite.component.card.cardcontainer.render.d(this.c, this.a);
        goto L14
    L18:
        throw new IllegalArgumentException("unsupported render type");
    }
}
