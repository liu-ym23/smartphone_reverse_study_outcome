package com.bytedance.android.live.openplatform.api.model.datacontext;

import com.bytedance.android.live.openplatform.api.model.shelf.ShelfInfo;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/model/datacontext/MiniAppDataContext;", "Lcom/bytedance/android/live/openplatform/api/model/datacontext/OpenPlatformDataContext;", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/live/openplatform/api/model/shelf/ShelfInfo;", "shelfInfo$delegate", "Lcom/bytedance/live/datacontext/p;", "getShelfInfo", "()Lcom/bytedance/live/datacontext/n;", "shelfInfo", "<init>", "()V", "Companion", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniAppDataContext extends OpenPlatformDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p shelfInfo$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static MiniAppDataContext a() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L9;
            i r1 = r0.isAnchor();
            if (r1 == null) goto L9;
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L9;
            OpenPlatformDataContext.Companion.getClass();
            return (MiniAppDataContext) OpenPlatformDataContext.a.a(AudienceMiniAppDataContext.class);
        L9:
            OpenPlatformDataContext.Companion.getClass();
            return (MiniAppDataContext) OpenPlatformDataContext.a.a(AnchorMiniAppDataContext.class);
        }

        @JvmStatic
        public static ShelfInfo b() {
            MiniAppDataContext r0 = a();
            if (r0 == null) goto L7;
            n<ShelfInfo> r1 = r0.m618getShelfInfo();
            if (r1 == null) goto L7;
            return (ShelfInfo) r1.getValue();
        L7:
            return null;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MiniAppDataContext.class, "shelfInfo", "getShelfInfo()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MiniAppDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    @JvmStatic
    public static final ShelfInfo getShelfInfo() {
        Companion.getClass();
        return a.b();
    }

    /* JADX INFO: renamed from: getShelfInfo, reason: collision with other method in class */
    public final n<ShelfInfo> m618getShelfInfo() {
        return (n) this.shelfInfo$delegate.a(this, $$delegatedProperties[0]);
    }

    public MiniAppDataContext() {
        this.shelfInfo$delegate = q.c(this);
    }
}
