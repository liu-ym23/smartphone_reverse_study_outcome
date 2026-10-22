package com.larus.voicecall.impl.interpret;

import android.view.View;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.scene.m;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import l3a.c;
import u3a.b;
import u3a.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0015H\u0016J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u0004\u0018\u00010\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001d\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/larus/voicecall/impl/interpret/RealtimeInterpretComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/interpret/IRealtimeInterpretAbility;", "<init>", "()V", "TAG", NameKeys.UnloadStrategy_No_Strategy, "sceneAbility", "Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "getSceneAbility", "()Lcom/larus/voicecall/impl/component/scene/IRealtimeSceneAbility;", "sceneAbility$delegate", "Lkotlin/Lazy;", "contentAbility", "Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "getContentAbility", "()Lcom/larus/voicecall/impl/component/content/IRealtimeContentAbility;", "contentAbility$delegate", "sceneChangeListener", "Lcom/larus/voicecall/impl/component/scene/RealtimeSceneChangeListener;", "onAttach", NameKeys.UnloadStrategy_No_Strategy, "onViewCreated", "view", "Landroid/view/View;", "onDestroy", "onSceneChange", "selectedSceneItem", "Lcom/larus/voicecall/impl/scene/SceneDisplayItem;", "isInInterpretMode", NameKeys.UnloadStrategy_No_Strategy, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeInterpretComponent extends RealtimeComponent implements u3a.a {
    public static final /* synthetic */ int r = 0;
    public final String n;
    public final Lazy o;
    public final Lazy p;
    public final a q;

    public static final class a implements c {
        public final /* synthetic */ RealtimeInterpretComponent a;

        public a(RealtimeInterpretComponent r1) {
            this.a = r1;
        }

        @Override // l3a.c
        public final void a(m r5) {
            FLogger.a.i(this.a.n, "[onSceneSelected] selected: " + r5);
            RealtimeInterpretComponent r0 = this.a;
            if (r5 == null) goto L9;
            g3a.a r2 = (g3a.a) r0.p.getValue();
            if (r2 == null) goto L7;
            r2.No(r5);
            Unit r6 = Unit.INSTANCE;
        L8:
            if (r6 == null) goto L9;
            return;
        L7:
            r6 = null;
        L9:
            g3a.a r7 = (g3a.a) r0.p.getValue();
            if (r7 == null) goto L14;
            r7.No(null);
            Unit r8 = Unit.INSTANCE;
            return;
        }
    }

    public final void onDestroy() {
        com.larus.voicecall.impl.component.scene.a r0 = (com.larus.voicecall.impl.component.scene.a) this.o.getValue();
        if (r0 == null) goto L6;
        r0.Fk(this.q);
        return;
    }

    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, u3a.a.class);
    }

    public RealtimeInterpretComponent() {
        this.n = "InterpretComponent";
        this.o = LazyKt.lazy(new b(this));
        this.p = LazyKt.lazy(new u3a.c(this));
        this.q = new a(this);
    }

    @Override // u3a.a
    public final boolean YM() {
        return f.e();
    }

    public final void onViewCreated(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r2, "view");
        com.larus.voicecall.impl.component.scene.a r3 = (com.larus.voicecall.impl.component.scene.a) this.o.getValue();
        if (r3 == null) goto L6;
        r3.yM(this.q);
        return;
    }
}
