package com.obric.memorydata.memory.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/obric/memorydata/memory/utils/SystemUtil;", "", "<init>", "()V", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f11566a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f11567b = null;
    private static Point c;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\u000bH\u0007J\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/memorydata/memory/utils/SystemUtil$Companion;", "", "<init>", "()V", "TAG", "", "phoneCount", "", "getPhoneCount", "()I", "screenRealSize", "Landroid/graphics/Point;", "getScreenSize", "isPrivacyAllowed", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Point a() {
            if (v.a() != null) goto L5;
            Point r3 = new Point();
            Object r0 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSystemService("window");
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) ZeusTransformUtils.preCheckCast(r0, WindowManager.class, "com.obric.memorydata.plugin")).getDefaultDisplay().getRealSize(r3);
            v.a(new Point(Math.min(r3.x, r3.y), Math.max(r3.x, r3.y)));
        L5:
            Point r4 = v.a();
            Intrinsics.checkNotNull(r4);
            return r4;
        }

        public final boolean b() {
            boolean r7 = UserSettings.INSTANCE.hasAgreePrivacy();
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), v.b(), "isPrivacyAllowed=" + r7, false, 4, null);
            return r7;
        }
    }

    static {
        f11566a = new a(null);
        f11567b = "SystemUtil";
    }

    public static final /* synthetic */ Point a() {
        return c;
    }

    public static final /* synthetic */ void a(Point r0) {
        c = r0;
    }

    public static final /* synthetic */ String b() {
        return f11567b;
    }
}
