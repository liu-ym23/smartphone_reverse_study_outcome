package com.bytedance.android.live.openplatform.api.model.datacontext;

import com.bytedance.android.live.openplatform.api.model.event.ToolbarEvent;
import com.bytedance.android.live.openplatform.api.model.shelf.f;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import ko0.d;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/datacontext/AudienceMiniAppDataContext;", "Lcom/bytedance/android/live/openplatform/api/model/datacontext/MiniAppDataContext;", "Lcom/bytedance/live/datacontext/n;", "Llo0/a;", "privateMsgEntranceInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getPrivateMsgEntranceInfo", "()Lcom/bytedance/live/datacontext/n;", "privateMsgEntranceInfo", "Lcom/bytedance/android/live/openplatform/api/model/shelf/f;", "shelfCardSupplementInfoMap$delegate", "getShelfCardSupplementInfoMap", "shelfCardSupplementInfoMap", "Lcom/bytedance/live/datacontext/m;", "Lko0/d;", "snowIconAnimInfo$delegate", "getSnowIconAnimInfo", "()Lcom/bytedance/live/datacontext/m;", "snowIconAnimInfo", "Lcom/bytedance/android/live/openplatform/api/model/event/ToolbarEvent;", "toolbarEvent$delegate", "getToolbarEvent", "toolbarEvent", "<init>", "()V", "Companion", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniAppDataContext extends MiniAppDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p privateMsgEntranceInfo$delegate;
    private final p shelfCardSupplementInfoMap$delegate;
    private final p snowIconAnimInfo$delegate;
    private final p toolbarEvent$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static AudienceMiniAppDataContext a() {
            OpenPlatformDataContext.Companion.getClass();
            return (AudienceMiniAppDataContext) OpenPlatformDataContext.a.a(AudienceMiniAppDataContext.class);
        }

        @JvmStatic
        public static d b() {
            AudienceMiniAppDataContext r0 = a();
            if (r0 == null) goto L7;
            m<d> r1 = r0.m617getSnowIconAnimInfo();
            if (r1 == null) goto L7;
            return (d) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AudienceMiniAppDataContext.class, "privateMsgEntranceInfo", "getPrivateMsgEntranceInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceMiniAppDataContext.class, "shelfCardSupplementInfoMap", "getShelfCardSupplementInfoMap()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceMiniAppDataContext.class, "snowIconAnimInfo", "getSnowIconAnimInfo()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceMiniAppDataContext.class, "toolbarEvent", "getToolbarEvent()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final AudienceMiniAppDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final d getSnowIconAnimInfo() {
        Companion.getClass();
        return a.b();
    }

    public final n<lo0.a> getPrivateMsgEntranceInfo() {
        return (n) this.privateMsgEntranceInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<f> getShelfCardSupplementInfoMap() {
        return (n) this.shelfCardSupplementInfoMap$delegate.a(this, $$delegatedProperties[1]);
    }

    /* JADX INFO: renamed from: getSnowIconAnimInfo, reason: collision with other method in class */
    public final m<d> m617getSnowIconAnimInfo() {
        return (m) this.snowIconAnimInfo$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<ToolbarEvent> getToolbarEvent() {
        return (n) this.toolbarEvent$delegate.a(this, $$delegatedProperties[3]);
    }

    public AudienceMiniAppDataContext() {
        this.privateMsgEntranceInfo$delegate = q.c(this);
        this.shelfCardSupplementInfoMap$delegate = q.c(this);
        this.snowIconAnimInfo$delegate = q.d(this, new d());
        this.toolbarEvent$delegate = q.c(this);
    }
}
