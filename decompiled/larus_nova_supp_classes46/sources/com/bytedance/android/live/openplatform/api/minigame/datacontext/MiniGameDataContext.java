package com.bytedance.android.live.openplatform.api.minigame.datacontext;

import com.bytedance.android.live.openplatform.api.model.datacontext.OpenPlatformDataContext;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.live.datacontext.i;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/datacontext/MiniGameDataContext;", "Lcom/bytedance/android/live/openplatform/api/model/datacontext/OpenPlatformDataContext;", "Lcom/bytedance/live/datacontext/m;", "", "instantPlayOpenStatus$delegate", "Lcom/bytedance/live/datacontext/p;", "getInstantPlayOpenStatus", "()Lcom/bytedance/live/datacontext/m;", "instantPlayOpenStatus", "instantPlayToggleStatus$delegate", "getInstantPlayToggleStatus", "instantPlayToggleStatus", "", "gameId$delegate", "getGameId", "gameId", "<init>", "()V", "Companion", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class MiniGameDataContext extends OpenPlatformDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int INSTANT_PLAY_CLOSE = 2;
    public static final int INSTANT_PLAY_OPEN = 1;
    private final p gameId$delegate;
    private final p instantPlayOpenStatus$delegate;
    private final p instantPlayToggleStatus$delegate;

    public static final class a {
        @JvmStatic
        public static MiniGameDataContext a() {
            RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
            if (r0 == null) goto L9;
            i r1 = r0.isAnchor();
            if (r1 == null) goto L9;
            if (((Boolean) r1.getValue()).booleanValue() == true) goto L9;
            OpenPlatformDataContext.Companion.getClass();
            return (MiniGameDataContext) OpenPlatformDataContext.a.a(AudienceMiniGameDataContext.class);
        L9:
            OpenPlatformDataContext.Companion.getClass();
            return (MiniGameDataContext) OpenPlatformDataContext.a.a(AnchorMiniGameDataContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MiniGameDataContext.class, "instantPlayOpenStatus", "getInstantPlayOpenStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MiniGameDataContext.class, "instantPlayToggleStatus", "getInstantPlayToggleStatus()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(MiniGameDataContext.class, "gameId", "getGameId()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final MiniGameDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    public final m<String> getGameId() {
        return (m) this.gameId$delegate.a(this, $$delegatedProperties[2]);
    }

    public final m<Integer> getInstantPlayOpenStatus() {
        return (m) this.instantPlayOpenStatus$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Integer> getInstantPlayToggleStatus() {
        return (m) this.instantPlayToggleStatus$delegate.a(this, $$delegatedProperties[1]);
    }

    public MiniGameDataContext() {
        this.instantPlayOpenStatus$delegate = q.d(this, 0);
        this.instantPlayToggleStatus$delegate = q.d(this, 0);
        this.gameId$delegate = q.d(this, "");
    }
}
