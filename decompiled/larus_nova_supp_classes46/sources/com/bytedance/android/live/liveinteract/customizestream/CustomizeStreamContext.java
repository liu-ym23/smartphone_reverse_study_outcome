package com.bytedance.android.live.liveinteract.customizestream;

import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000  2\u00020\u00012\u00020\u0002:\u0001!B\u0007¢\u0006\u0004\b\u001e\u0010\u001fR!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\u0006\u001a\u0004\b\r\u0010\u000eR!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u000eR!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u000eR!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u000eR!\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001a0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0006\u001a\u0004\b\u001c\u0010\u000e¨\u0006\""}, d2 = {"Lcom/bytedance/android/live/liveinteract/customizestream/CustomizeStreamContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/liveinteract/customizestream/b;", "service$delegate", "Lcom/bytedance/live/datacontext/p;", "getService", "()Lcom/bytedance/live/datacontext/j;", "service", "Lcom/bytedance/live/datacontext/m;", "", "customizeStreamStarted$delegate", "getCustomizeStreamStarted", "()Lcom/bytedance/live/datacontext/m;", "customizeStreamStarted", "guestInCustomizeStreamLayout$delegate", "getGuestInCustomizeStreamLayout", "guestInCustomizeStreamLayout", "needHideAudioBg$delegate", "getNeedHideAudioBg", "needHideAudioBg", "", "customizeStreamType$delegate", "getCustomizeStreamType", "customizeStreamType", "", "customizeWTNStreamID$delegate", "getCustomizeWTNStreamID", "customizeWTNStreamID", "<init>", "()V", "Companion", "a", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CustomizeStreamContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final int CUSTOMIZE_STREAM_TYPE_DIGITAL_HUMAN = 2;
    public static final int CUSTOMIZE_STREAM_TYPE_NORMAL = 1;
    public static final a Companion = null;
    public static final String KEY_CUSTOMIZE_STREAM_DATA = "key_customize_stream_data";
    public static final String LOG_TAG = "customize_stream";
    private final p customizeStreamStarted$delegate;
    private final p customizeStreamType$delegate;
    private final p customizeWTNStreamID$delegate;
    private final p guestInCustomizeStreamLayout$delegate;
    private final p needHideAudioBg$delegate;
    private final p service$delegate;

    public static final class a {
        public a() {
        }

        public final CustomizeStreamContext getContext() {
            DataContext r0 = d.d(CustomizeStreamContext.KEY_CUSTOMIZE_STREAM_DATA);
            if ((r0 instanceof CustomizeStreamContext) == true) goto L6;
            r0 = null;
        L6:
            return (CustomizeStreamContext) r0;
        }

        public final b a() {
            CustomizeStreamContext r0 = getContext();
            if (r0 == null) goto L7;
            j<b> r1 = r0.getService();
            if (r1 == null) goto L7;
            return (b) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "service", "getService()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "customizeStreamStarted", "getCustomizeStreamStarted()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "guestInCustomizeStreamLayout", "getGuestInCustomizeStreamLayout()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "needHideAudioBg", "getNeedHideAudioBg()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "customizeStreamType", "getCustomizeStreamType()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(CustomizeStreamContext.class, "customizeWTNStreamID", "getCustomizeWTNStreamID()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    public final m<Boolean> getCustomizeStreamStarted() {
        return (m) this.customizeStreamStarted$delegate.a(this, $$delegatedProperties[1]);
    }

    public final m<Integer> getCustomizeStreamType() {
        return (m) this.customizeStreamType$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<String> getCustomizeWTNStreamID() {
        return (m) this.customizeWTNStreamID$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Boolean> getGuestInCustomizeStreamLayout() {
        return (m) this.guestInCustomizeStreamLayout$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Boolean> getNeedHideAudioBg() {
        return (m) this.needHideAudioBg$delegate.a(this, $$delegatedProperties[3]);
    }

    public final j<b> getService() {
        return (j) this.service$delegate.a(this, $$delegatedProperties[0]);
    }

    public CustomizeStreamContext() {
        this.service$delegate = ConstantKt.c(this);
        Boolean r0 = Boolean.FALSE;
        this.customizeStreamStarted$delegate = q.d(this, r0);
        this.guestInCustomizeStreamLayout$delegate = q.d(this, r0);
        this.needHideAudioBg$delegate = q.d(this, r0);
        this.customizeStreamType$delegate = q.d(this, 1);
        this.customizeWTNStreamID$delegate = q.d(this, "");
    }
}
