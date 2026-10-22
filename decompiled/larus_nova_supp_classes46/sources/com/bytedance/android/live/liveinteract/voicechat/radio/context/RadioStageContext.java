package com.bytedance.android.live.liveinteract.voicechat.radio.context;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.p;
import jk0.c;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \f2\u00020\u00012\u00020\u0002:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/liveinteract/voicechat/radio/context/RadioStageContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/live/liveinteract/voicechat/radio/context/a;", "Lcom/bytedance/live/datacontext/j;", "Ljk0/c;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RadioStageContext extends DataContext implements com.bytedance.android.live.liveinteract.voicechat.radio.context.a {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final String TAG_FOR_FEED = "MultiLinkDynamicFeedContext";
    public static final String TAG_FOR_LIVE = "MultiLinkDynamicContext";
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final RadioStageContext getContext() {
            DataContext r0 = d.d(com.bytedance.android.live.liveinteract.voicechat.radio.context.a.class);
            if ((r0 instanceof RadioStageContext) == true) goto L6;
            r0 = null;
        L6:
            return (RadioStageContext) r0;
        }

        public final c a() {
            RadioStageContext r0 = getContext();
            if (r0 == null) goto L7;
            j<c> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (c) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(RadioStageContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final RadioStageContext getContext() {
        return Companion.getContext();
    }

    public final j<c> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public RadioStageContext() {
        this.service$delegate = ConstantKt.c(this);
    }
}
