package com.obric.memorydata.personalcontext.collector;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MediaFileContentObserver;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "<init>", "(Landroid/os/Handler;)V", "onChange", "", "selfChange", "", "uri", "Landroid/net/Uri;", "Companion", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class f extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12067a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f12068b = null;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/personalcontext/collector/MediaFileContentObserver$Companion;", "", "<init>", "()V", "TAG", "", "KEY_CHANGE_TYPE", "KEY_DELETE", "DOC_URI", "Landroid/net/Uri;", "getDOC_URI", "()Landroid/net/Uri;", "obric_entity_data_collector_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final Uri a() {
            return f.a();
        }
    }

    static {
        f12067a = new a(null);
        Uri r0 = MediaStore.AUTHORITY_URI.buildUpon().appendPath("external").appendPath("document").build();
        Intrinsics.checkNotNullExpressionValue(r0, "build(...)");
        f12068b = r0;
    }

    public f(Handler r1) {
        super(r1);
    }

    public static final /* synthetic */ Uri a() {
        return f12068b;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean r8, Uri r9) {
        RunLog.INSTANCE.debug("MediaFileContentObserver", "onChange called, uri: " + r9);
        super.onChange(r8, r9);
        kotlinx.coroutines.i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new MediaFileContentObserver$onChange$1(r9, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }
}
