package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.bytedance.android.livesdkapi.hybridapi.IJsBridgeManager;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0007\n\u0002\b\u0004*\u0001\u0000\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"com/bytedance/android/livesdk/chatroom/widget/TopicGetParamsMethodWidget$methodFactory$2$a", "invoke", "()Lcom/bytedance/android/livesdk/chatroom/widget/TopicGetParamsMethodWidget$methodFactory$2$a;", "<anonymous>"}, k = 3, mv = {1, 4, 3})
public final class TopicGetParamsMethodWidget$methodFactory$2 extends Lambda implements Function0<a> {
    final /* synthetic */ TopicGetParamsMethodWidget this$0;

    public static final class a extends BaseJsBridgeMethodFactory {
        public final /* synthetic */ TopicGetParamsMethodWidget$methodFactory$2 a;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.chatroom.widget.TopicGetParamsMethodWidget$methodFactory$2$a$a, reason: collision with other inner class name */
        public static final class C0090a implements com.bytedance.ies.web.jsbridge2.f.b {
            public final /* synthetic */ a a;

            public C0090a(a r1) {
                this.a = r1;
            }

            public final com.bytedance.ies.web.jsbridge2.f<Object, Object> a() {
                return new e0(((Widget) this.a.a.this$0).dataCenter);
            }
        }

        public a(TopicGetParamsMethodWidget$methodFactory$2 r1) {
            this.a = r1;
        }

        public final Map<String, com.bytedance.ies.web.jsbridge2.f.b> provideStatefulMethods(IJsBridgeManager r2) {
            Intrinsics.checkNotNullParameter(r2, "manager");
            return MapsKt.mapOf(TuplesKt.to("live.getAnchorTopicParams", new C0090a(this)));
        }
    }

    public TopicGetParamsMethodWidget$methodFactory$2(TopicGetParamsMethodWidget r1) {
        this.this$0 = r1;
        super(0);
    }

    public final a invoke() {
        return new a(this);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m403invoke() {
        return invoke();
    }
}
