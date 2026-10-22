package com.bytedance.android.live.room.api.messagewindow.service;

import com.bytedance.android.live.base.IService;
import com.bytedance.android.live.room.api.messagewindow.monitor.i;
import com.bytedance.android.live.utility.ServiceLookup;
import d71.d;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import r71.c;
import y61.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ServiceLookup("com.bytedance.android.live.messagewindow.service.PlatformCardService")
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH&J\b\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u0015\u001a\u00020\u0014H&¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/room/api/messagewindow/service/IPlatformCardService;", "Lcom/bytedance/android/live/base/IService;", "Lv61/a;", "cardWindow", "Lr61/a;", "newCardAbilityImpl", "Ly61/b;", "msgWindowCtx", "Le71/a;", "newCardManager", "Lq71/d;", "Lr71/c;", "recordState", "Ld71/d;", "Ld71/b;", "newRecordManager", "Lu61/a;", "newCardBuilder", "Li71/a;", "newCardScheduler", "Lcom/bytedance/android/live/room/api/messagewindow/monitor/i;", "cardMonitor", "Companion", "a", "experience-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IPlatformCardService extends IService {
    public static final a Companion = null;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.api.messagewindow.service.IPlatformCardService$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            a r0 = IPlatformCardService.Companion;
        }

        @JvmStatic
        public static IPlatformCardService inst() {
            IPlatformCardService.Companion.getClass();
            return a.a();
        }
    }

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }

        @JvmStatic
        public static IPlatformCardService a() {
            return (IPlatformCardService) k.f(IPlatformCardService.class);
        }
    }

    static {
        Companion = a.a;
    }

    i cardMonitor();

    r61.a newCardAbilityImpl(v61.a r1);

    u61.a newCardBuilder();

    e71.a newCardManager(b r1);

    i71.a newCardScheduler(b r1);

    d<v61.a, d71.b> newRecordManager(q71.d<c> r1);
}
