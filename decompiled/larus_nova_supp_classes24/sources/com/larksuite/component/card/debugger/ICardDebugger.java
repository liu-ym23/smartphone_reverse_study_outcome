package com.larksuite.component.card.debugger;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larksuite.component.card.plugin.OPPlugin;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public interface ICardDebugger {
    public static final Companion a = null;

    public static final class Companion {
        public static final /* synthetic */ Companion a = null;
        public static final Lazy<ICardDebugger> b = null;

        public Companion() {
        }

        static {
            a = new Companion();
            b = LazyKt.lazy(ICardDebugger$Companion$instance$2.INSTANCE);
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class a() throws ClassNotFoundException {
            ConcurrentHashMap r0 = FastClassNotFoundHandler.a;
            FastClassNotFoundHandler.Status r1 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class<?> r2 = Class.forName("com.larksuite.component.carddebugger.CardDebuggerImpl");     // Catch: Throwable -> L8
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a("com.larksuite.component.carddebugger.CardDebuggerImpl");     // Catch: Throwable -> L8
        L7:
            return r2;
        L8:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b("com.larksuite.component.carddebugger.CardDebuggerImpl");
        L12:
            throw th;
        L34:
            Class<?> r3 = Class.forName("com.larksuite.component.carddebugger.CardDebuggerImpl");     // Catch: Throwable -> L17
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a("com.larksuite.component.carddebugger.CardDebuggerImpl");     // Catch: Throwable -> L17
        L16:
            return r3;
        L17:
            th = move-exception;
            if (r1 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b("com.larksuite.component.carddebugger.CardDebuggerImpl");
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName("com.larksuite.component.carddebugger.CardDebuggerImpl");
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larksuite/component/card/debugger/ICardDebugger$DebugRenderInfo;", "Ljava/io/Serializable;", "mockEnable", "", "rawData", "", "<init>", "(ZLjava/lang/String;)V", "getMockEnable", "()Z", "getRawData", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public static final class DebugRenderInfo implements Serializable {
        private final boolean mockEnable;
        private final String rawData;

        public static /* synthetic */ DebugRenderInfo copy$default(DebugRenderInfo r0, boolean r1, String r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.mockEnable;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.rawData;
        L9:
            return r0.copy(r1, r2);
        }

        public final boolean component1() {
            return this.mockEnable;
        }

        public final String component2() {
            return this.rawData;
        }

        public final DebugRenderInfo copy(boolean r2, String r3) {
            return new DebugRenderInfo(r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DebugRenderInfo) == true) goto L8;
            return false;
        L8:
            DebugRenderInfo r6 = (DebugRenderInfo) r5;
            if (this.mockEnable == r6.mockEnable) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.rawData, r6.rawData) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            if (this.mockEnable == false) goto L5;
            int r0 = 1231;
        L6:
            int r1 = r0 * 31;
            String r2 = this.rawData;
            if (r2 != null) goto L9;
            int r3 = 0;
        L11:
            return r1 + r3;
        L9:
            r3 = r2.hashCode();
            goto L11
        L5:
            r0 = 1237;
            goto L6
        }

        public String toString() {
            return "DebugRenderInfo(mockEnable=" + this.mockEnable + ", rawData=" + this.rawData + ')';
        }

        public final boolean getMockEnable() {
            return this.mockEnable;
        }

        public final String getRawData() {
            return this.rawData;
        }

        public DebugRenderInfo(boolean r1, String r2) {
            this.mockEnable = r1;
            this.rawData = r2;
        }
    }

    static {
        a = Companion.a;
    }

    List<OPPlugin> a();

    List<com.lynx.tasm.behavior.a> b();

    void getEnable();
}
