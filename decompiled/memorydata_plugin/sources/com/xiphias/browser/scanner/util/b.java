package com.xiphias.browser.scanner.util;

import android.content.Context;
import android.util.Size;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/xiphias/browser/scanner/util/ScreenUtil;", "", "<init>", "()V", "Companion", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16357a = null;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b¨\u0006\u000e"}, d2 = {"Lcom/xiphias/browser/scanner/util/ScreenUtil$Companion;", "", "<init>", "()V", "getScreenSize", "Landroid/util/Size;", "context", "Landroid/content/Context;", "isDefaultToPortrait", "", "activity", "Landroid/app/Activity;", "getDisplayRotation", "", "scanner_selectedRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Size a(Context r2) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "context");
            Object r3 = r1.getSystemService("window");
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type android.view.WindowManager");
            WindowMetrics r4 = ((WindowManager) ZeusTransformUtils.preCheckCast(r3, WindowManager.class, "com.obric.memorydata.plugin")).getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(r4, "getCurrentWindowMetrics(...)");
            return new Size(r4.getBounds().width(), r4.getBounds().height());
        }
    }

    static {
        f16357a = new a(null);
    }
}
