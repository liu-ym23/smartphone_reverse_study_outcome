package com.ss.android.lark.monitor.perf;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.monitor.MonitorModule;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000bH$R\u000e\u0010\n\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/monitor/perf/ResourcePerfMonitor;", "", "<init>", "(Ljava/lang/String;I)V", "VIDEO_SEND", "IMAGE_SEND", "VIDEO_PLAY", "IMAGE_PREVIEW", "ALBUM_OPEN", "IMAGE_EDITOR", "TAG", "", "hasStarted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "onStart", "", "onEnd", "getSceneName", "monitor_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public abstract enum ResourcePerfMonitor extends Enum<ResourcePerfMonitor> {
    public static final ResourcePerfMonitor ALBUM_OPEN = null;
    public static final ResourcePerfMonitor IMAGE_EDITOR = null;
    public static final ResourcePerfMonitor IMAGE_PREVIEW = null;
    public static final ResourcePerfMonitor IMAGE_SEND = null;
    public static final ResourcePerfMonitor VIDEO_PLAY = null;
    public static final ResourcePerfMonitor VIDEO_SEND = null;
    public static final /* synthetic */ ResourcePerfMonitor[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final String TAG;
    private AtomicBoolean hasStarted;

    public ResourcePerfMonitor() {
        throw null;
    }

    public static EnumEntries<ResourcePerfMonitor> getEntries() {
        return b;
    }

    public abstract String getSceneName();

    static {
        final String r1 = "VIDEO_SEND";
        final int r2 = 0;
        ResourcePerfMonitor r0 = new VIDEO_SEND(r1, r2);
        VIDEO_SEND = r0;
        final String r3 = "IMAGE_SEND";
        final int r4 = 1;
        ResourcePerfMonitor r5 = new IMAGE_SEND(r3, r4);
        IMAGE_SEND = r5;
        final String r6 = "VIDEO_PLAY";
        final int r7 = 2;
        ResourcePerfMonitor r8 = new VIDEO_PLAY(r6, r7);
        VIDEO_PLAY = r8;
        final String r9 = "IMAGE_PREVIEW";
        final int r10 = 3;
        ResourcePerfMonitor r11 = new IMAGE_PREVIEW(r9, r10);
        IMAGE_PREVIEW = r11;
        final String r12 = "ALBUM_OPEN";
        final int r13 = 4;
        ResourcePerfMonitor r14 = new ALBUM_OPEN(r12, r13);
        ALBUM_OPEN = r14;
        final String r15 = "IMAGE_EDITOR";
        final int r16 = 5;
        ResourcePerfMonitor r17 = new IMAGE_EDITOR(r15, r16);
        IMAGE_EDITOR = r17;
        ResourcePerfMonitor[] r18 = {r0, r5, r8, r11, r14, r17};
        a = r18;
        b = EnumEntriesKt.enumEntries(r18);
    }

    public static ResourcePerfMonitor[] values() {
        return (ResourcePerfMonitor[]) a.clone();
    }

    public final void onEnd() {
        String r0 = getSceneName();
        if (this.hasStarted.get() == false) goto L5;
        this.hasStarted.set(false);
        Log.i(this.TAG, "onEnd success, scene:" + r0);
        MonitorModule.e().h(MonitorModule.Business.messenger, r0);
        return;
    L5:
        Log.i(this.TAG, "onEnd, no has started, scene:" + r0);
    }

    public final void onStart() {
        String r0 = getSceneName();
        if (this.hasStarted.get() == false) goto L5;
        Log.i(this.TAG, "onStart, has started, scene:" + r0);
        return;
    L5:
        this.hasStarted.set(true);
        Log.i(this.TAG, "onStart success, scene:" + r0);
        MonitorModule.e().f(MonitorModule.Business.messenger, r0);
    }

    public static ResourcePerfMonitor valueOf(String r1) {
        return (ResourcePerfMonitor) r27.a.a(ResourcePerfMonitor.class, r1);
    }

    public ResourcePerfMonitor(String r1, int r2, DefaultConstructorMarker r3) {
        super(r1, r2);
        this.TAG = "ResourcePerfMonitor";
        this.hasStarted = new AtomicBoolean(false);
    }
}
