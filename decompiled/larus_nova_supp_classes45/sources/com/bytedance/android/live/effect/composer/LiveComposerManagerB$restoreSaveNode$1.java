package com.bytedance.android.live.effect.composer;

import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.effect.api.ILiveEffectComposerManager;
import com.bytedance.android.live.effect.api.LiveEffectContextFactoryDelegate$Type;
import com.bytedance.android.live.effect.api.d0;
import com.bytedance.android.live.effect.api.u;
import com.bytedance.android.live.effect.base.setting.LiveEffectSettings;
import com.bytedance.common.utility.Logger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"checkRestoreStatus", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class LiveComposerManagerB$restoreSaveNode$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $panel;
    final /* synthetic */ LiveComposerManagerB this$0;

    public static final class a implements Runnable {
        public final /* synthetic */ LiveComposerManagerB$restoreSaveNode$1 a;

        public a(LiveComposerManagerB$restoreSaveNode$1 r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LiveComposerManagerB$restoreSaveNode$1 r0 = this.a;     // Catch: Throwable -> L7
            LiveComposerManagerB r1 = r0.this$0;     // Catch: Throwable -> L7
            Map<String, List<n>> r2 = r1.h;     // Catch: Throwable -> L7
            LinkedHashMap r3 = (LinkedHashMap) r2;     // Catch: Throwable -> L7
            List<n> r4 = (List) r3.get(r0.$panel);     // Catch: Throwable -> L7
            if (r4 != null) goto L5;
            r4 = CollectionsKt.emptyList();     // Catch: Throwable -> L7
        L5:
            r1.g0(r4, new StringBuilder());     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ LiveComposerManagerB$restoreSaveNode$1 a;

        public b(LiveComposerManagerB$restoreSaveNode$1 r1) {
            this.a = r1;
        }

        public final void a() {
            LiveComposerManagerB$restoreSaveNode$1 r0 = this.a;
            r0.this$0.y.put(r0.$panel, Long.valueOf(System.currentTimeMillis()));
            this.a.this$0.getClass();
            Logger.w("LiveComposerManagerB", this.a.$panel + " restore complete, current size: " + this.a.this$0.y.size() + ", target size: 0");
            int r1 = this.a.this$0.y.size();
            LiveComposerManagerB r2 = this.a.this$0;
            r2.getClass();
            if (r1 == 0) goto L5;
            return;
        L5:
            if (r2.z == true) goto L12;
            this.a.this$0.z = true;
            Logger.w("LiveComposerManagerB", "all restore complete!");
            this.a.this$0.x = System.currentTimeMillis();
            Iterator r3 = ((ArrayList) this.a.this$0.w).iterator();
        L8:
            if (r3.hasNext() == false) goto L13;
            ILiveEffectComposerManager.j r4 = (ILiveEffectComposerManager.j) r3.next();
            LiveComposerManagerB r5 = this.a.this$0;
            r4.a(r5.x, r5.y);
            goto L8
        L13:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ LiveComposerManagerB$restoreSaveNode$1 a;
        public final /* synthetic */ com.bytedance.android.live.effect.sticker.presenter.n b;

        public c(LiveComposerManagerB$restoreSaveNode$1 r1, com.bytedance.android.live.effect.sticker.presenter.n r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void a() {
            if (this.b.d() == false) goto L19;
            com.bytedance.android.live.effect.sticker.presenter.n.a r0 = com.bytedance.android.live.effect.sticker.presenter.n.a;
            r0.getClass();
            if (com.bytedance.android.live.effect.sticker.presenter.n.a.a.contains(this.a.$panel) == false) goto L7;
        L8:
            LiveComposerManagerB$restoreSaveNode$1 r1 = this.a;
            List<String> r2 = r1.this$0.A;
            ArrayList r3 = (ArrayList) r2;
            if (r3.contains(r1.$panel) == true) goto L21;
            LiveComposerManagerB$restoreSaveNode$1 r4 = this.a;
            List<String> r5 = r4.this$0.A;
            ArrayList r6 = (ArrayList) r5;
            r6.add(r4.$panel);
            r0.getClass();
            int r7 = com.bytedance.android.live.effect.sticker.presenter.n.a.b;
            if (((ArrayList) this.a.this$0.A).size() != r7) goto L22;
            Iterator r8 = ((ArrayList) this.a.this$0.B).iterator();
        L14:
            if (r8.hasNext() == false) goto L16;
            ((ILiveEffectComposerManager.a) r8.next()).a();
            goto L14
        L16:
            ((ArrayList) this.a.this$0.B).clear();
            ((ArrayList) this.a.this$0.A).clear();
            return;
        L22:
            return;
        L21:
            return;
        L7:
            if (Intrinsics.areEqual(this.a.$panel, d0.a) == true) goto L8;
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public LiveComposerManagerB$restoreSaveNode$1(LiveComposerManagerB r1, String r2) {
        this.this$0 = r1;
        this.$panel = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m740invoke() {
        if (LiveEffectSettings.LIVE_EFFECT_ENABLE_START_LIVE_RESTORE_OPTIMIZE.getValue().booleanValue() == false) goto L5;
        MainThreadPostUtils.b(new a(this));
    L5:
        MainThreadPostUtils.b(new b(this));
        Map<LiveEffectContextFactoryDelegate$Type, com.bytedance.android.live.effect.api.e> r0 = u.a;
        com.bytedance.android.live.effect.sticker.presenter.q r1 = u.b(this.this$0.getType()).e();
        if (r1.c() == false) goto L9;
        MainThreadPostUtils.b(new c(this, r1));
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m740invoke();
        return Unit.INSTANCE;
    }
}
