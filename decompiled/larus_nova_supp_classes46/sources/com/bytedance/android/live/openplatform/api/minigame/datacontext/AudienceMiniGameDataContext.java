package com.bytedance.android.live.openplatform.api.minigame.datacontext;

import com.bytedance.android.live.openplatform.api.model.datacontext.OpenPlatformDataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007¢\u0006\u0004\b\n\u0010\u000bR!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/openplatform/api/minigame/datacontext/AudienceMiniGameDataContext;", "Lcom/bytedance/android/live/openplatform/api/minigame/datacontext/MiniGameDataContext;", "Lcom/bytedance/live/datacontext/m;", "", "isCandyToolbarShow$delegate", "Lcom/bytedance/live/datacontext/p;", "isCandyToolbarShow", "()Lcom/bytedance/live/datacontext/m;", "isRoomBackground$delegate", "isRoomBackground", "<init>", "()V", "Companion", "a", "liveopenplatform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AudienceMiniGameDataContext extends MiniGameDataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    private final p isCandyToolbarShow$delegate;
    private final p isRoomBackground$delegate;

    public static final class a {
        @JvmStatic
        public static AudienceMiniGameDataContext a() {
            OpenPlatformDataContext.Companion.getClass();
            return (AudienceMiniGameDataContext) OpenPlatformDataContext.a.a(AudienceMiniGameDataContext.class);
        }

        public a() {
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(AudienceMiniGameDataContext.class, "isCandyToolbarShow", "isCandyToolbarShow()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(AudienceMiniGameDataContext.class, "isRoomBackground", "isRoomBackground()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final AudienceMiniGameDataContext getShared() {
        Companion.getClass();
        return a.a();
    }

    public final m<Boolean> isCandyToolbarShow() {
        return (m) this.isCandyToolbarShow$delegate.a(this, $$delegatedProperties[0]);
    }

    public final m<Boolean> isRoomBackground() {
        return (m) this.isRoomBackground$delegate.a(this, $$delegatedProperties[1]);
    }

    public AudienceMiniGameDataContext() {
        Boolean r0 = Boolean.FALSE;
        this.isCandyToolbarShow$delegate = q.d(this, r0);
        this.isRoomBackground$delegate = q.d(this, r0);
    }
}
