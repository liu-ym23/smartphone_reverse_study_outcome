package com.bytedance.android.live.effect.beauty.feedback;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.live.browser.jsbridge.base.CloseFeedbackPageResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.ies.web.jsbridge2.f;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import w20.e8;
import w20.w;
import y6.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/live/effect/beauty/feedback/PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a", "invoke", "()Lcom/bytedance/android/live/effect/beauty/feedback/PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
final class PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 extends Lambda implements Function0<a> {
    final /* synthetic */ b this$0;

    public static final class a implements IHybridComponent.a {
        public final /* synthetic */ PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.feedback.PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a$a, reason: collision with other inner class name */
        public static final class C0182a implements f.b {
            public final /* synthetic */ a a;

            /* JADX INFO: renamed from: com.bytedance.android.live.effect.beauty.feedback.PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2$a$a$a, reason: collision with other inner class name */
            public static final class C0183a extends w<e8, CloseFeedbackPageResultModel> {
                public final /* synthetic */ C0182a b;

                public C0183a(C0182a r1) {
                    this.b = r1;
                }

                public final void invoke(Object r2, CallContext r3) {
                    Intrinsics.checkNotNullParameter((e8) r2, "params");
                    Intrinsics.checkNotNullParameter(r3, "context");
                    ALogger.d("ttlive_anchor_effect_PreviewBeautyFeedbackManager", "onCloseFeedbackPage: hide feedback");
                    this.b.a.a.getClass();
                    int r4 = b.a;
                    throw null;
                }
            }

            public C0182a(a r1) {
                this.a = r1;
            }

            public final f<Object, Object> a() {
                return new C0183a(this);
            }
        }

        public a(PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2 r1) {
            this.a = r1;
        }

        public final void onJSBridgeCreated(c r3) {
            Intrinsics.checkNotNullParameter(r3, "manager");
            r3.registerMethod("closeFeedbackPage", new C0182a(this));
        }
    }

    public PreviewBeautyFeedbackManager$feedbackJSBridgeListener$2(b r1) {
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m697invoke() {
        return invoke();
    }
}
