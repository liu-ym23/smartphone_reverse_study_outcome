package com.bytedance.android.livesdk.drawer.relax;

import com.bytedance.android.rts.util.ComponentsRTSLiveImageKt;
import com.relax.relaxframework.ModifierValue_BackgroundClip;
import com.relax.relaxframework.ModifierValue_BackgroundSize;
import com.relax.relaxframework.ModifierValue_BorderStyle;
import com.relax.relaxframework.ModifierValue_BoxSizing;
import com.relax.relaxframework.RelaxFrameworkKt;
import com.relax.relaxframework.j5;
import com.relax.relaxframework.p6;
import com.relax.relaxframework.z2;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1 extends Lambda implements Function0<j5> {
    final /* synthetic */ MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1.AnonymousClass1 this$0;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.drawer.relax.MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/relax/relaxframework/j5;", "invoke", "()Lcom/relax/relaxframework/j5;", "<no name provided>"}, k = 3, mv = {1, 4, 3})
    public static final class AnonymousClass1 extends Lambda implements Function0<j5> {
        final /* synthetic */ MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1 this$0;

        public AnonymousClass1(MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1 r1) {
            this.this$0 = r1;
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public /* bridge */ /* synthetic */ Object m1016invoke() {
            return invoke();
        }

        public final j5 invoke() {
            Function2 r0 = ComponentsRTSLiveImageKt.b;
            Function0<String> r3 = new MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1$1$RTSLiveImage__1$1(this);
            int r4 = z2.a;
            j5 r1 = RelaxFrameworkKt.z(r0, new com.bytedance.android.rts.util.b("", r3, com.bytedance.rts.foundation.j.k(new p6[]{z2.a.e().f(RelaxFrameworkKt.h(RelaxFrameworkKt.b0(14), RelaxFrameworkKt.b0(0))), z2.a.g().r0(RelaxFrameworkKt.b0(20)).O(RelaxFrameworkKt.b0(20)), z2.a.g().j(RelaxFrameworkKt.b0(16), ModifierValue_BorderStyle.Solid, 0), z2.a.g().e(ModifierValue_BackgroundClip.PaddingBox), z2.a.g().N(ModifierValue_BoxSizing.ContentBox), z2.a.g().i(RelaxFrameworkKt.p(ModifierValue_BackgroundSize.Contain))}), null, new MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1$1$RTSLiveImage__1$2(this), null, null, 2024), null);
            if (r1 == null) goto L6;
            return r1;
        L6:
            throw new NullPointerException("null cannot be cast to non-null type com.relax.relaxframework.RxElement");
        }
    }

    public MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1$1$switch__4$1(MainpageHistoryListItemKt$LiveDrawerHistoryListItem$1$1$1$switch__1$2$match__1$1.AnonymousClass1 r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m1015invoke() {
        return invoke();
    }

    public final j5 invoke() {
        return (j5) new AnonymousClass1(this).invoke();
    }
}
