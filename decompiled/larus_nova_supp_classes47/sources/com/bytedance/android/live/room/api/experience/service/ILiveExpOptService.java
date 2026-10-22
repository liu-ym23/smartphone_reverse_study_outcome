package com.bytedance.android.live.room.api.experience.service;

import com.bytedance.android.livesdk.chatroom.MiddlewareRoomContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.DataContext;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \b2\u00020\u0001:\u0001\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/live/room/api/experience/service/ILiveExpOptService;", "Lcom/bytedance/android/live/room/api/experience/service/ILiveExpMiddlewareService;", "Lcom/bytedance/ies/sdk/widgets/DataCenter;", "dataCenter", "Lcom/bytedance/android/livesdk/chatroom/MiddlewareRoomContext;", "roomContext", "Lcom/bytedance/live/datacontext/DataContext;", "initRoomExpContext", "Companion", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveExpOptService extends ILiveExpMiddlewareService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.experience.service.ILiveExpOptService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r0 = ILiveExpOptService.Companion;
        }

        @JvmStatic
        public static ILiveExpOptService ins() {
            ILiveExpOptService.Companion.getClass();
            return (ILiveExpOptService) k.n(ILiveExpOptService.class);
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    static {
        Companion = a.a;
    }

    DataContext initRoomExpContext(DataCenter r1, MiddlewareRoomContext r2);
}
