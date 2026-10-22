package com.obric.assistant.upload;

import com.larus.bmhome.rc.ResourceCenter;
import com.larus.im.bean.message.UplinkFileEntity;
import com.obric.assistant.chat.internal.SingleImageWithTextHandler;
import com.obric.assistant.upload.internal.ObricFileUploader;
import com.obric.assistant.upload.internal.ObricUploadEntityCache;
import com.obric.assistant.upload.internal.ObricUploadEntityCache$entityMap$1;
import com.obric.assistant.upload.internal.e;
import com.obric.assistant.upload.internal.m;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import oha.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J*\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0016\u0010\u001a\u001a\u00020\r2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0019H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006 "}, d2 = {"Lcom/obric/assistant/upload/ObricUploadService;", "Lcom/obric/assistant/upload/IObricUploadService;", "<init>", "()V", "uploader", "Lcom/obric/assistant/upload/internal/ObricFileUploader;", "getUploader", "()Lcom/obric/assistant/upload/internal/ObricFileUploader;", "uploader$delegate", "Lkotlin/Lazy;", "generateUploadIdentifier", "", "addUploadListener", "", "identifier", "uploadListener", "Lcom/obric/assistant/upload/IObricUploadListener;", "removeUploadListener", "removeAllUploadListener", "uploadImage", "file", "Ljava/io/File;", "scene", "Lcom/obric/assistant/upload/Scene;", "getUploadCache", "Lcom/larus/im/bean/message/UplinkFileEntity;", "deleteRemoteResources", "identifiers", "", "addUsedCache", "entity", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUploadService implements IObricUploadService {
    public static final /* synthetic */ int c = 0;
    public final Lazy b;

    public static final class a {
    }

    static {
    }

    public ObricUploadService() {
        this.b = LazyKt.lazy(new b());
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final String d() {
        return UUID.randomUUID().toString();
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void c(String r3) {
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Map<String, Set<oha.a>> r1 = e.a;
        Intrinsics.checkNotNullParameter(r3, "identifier");
        int r0 = m.a;
        m.c("ObricUploadDispatcher", "removeAllUploadListener called, identifier = " + r3);
        e.a.remove(r3);
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void e(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "identifiers");
        ((ObricFileUploader) this.b.getValue()).getClass();
        ObricFileUploader.b(r2);
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final UplinkFileEntity g(String r4) {
        Intrinsics.checkNotNullParameter(r4, "identifier");
        ObricUploadEntityCache$entityMap$1 r0 = ObricUploadEntityCache.a;
        Intrinsics.checkNotNullParameter(r4, "identifier");
        Object r1 = ObricUploadEntityCache.c;
        monitor-enter(r1);
        UplinkFileEntity r5 = (UplinkFileEntity) ObricUploadEntityCache.a.get(r4);     // Catch: Throwable -> L17
        if (r5 == null) goto L14;
        ResourceCenter r2 = ResourceCenter.a;     // Catch: Throwable -> L17
        String r3 = r5.getFileIdentifier();     // Catch: Throwable -> L17
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        r2.getClass();     // Catch: Throwable -> L17
        if (ResourceCenter.d(r3) == false) goto L13;
        monitor-exit(r1);
        return r5;
    L13:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L17
    L14:
        monitor-exit(r1);
        return null;
    L17:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void b(String r3, UplinkFileEntity r4) {
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Intrinsics.checkNotNullParameter(r4, "entity");
        ((ObricFileUploader) this.b.getValue()).getClass();
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Intrinsics.checkNotNullParameter(r4, "entity");
        ObricUploadEntityCache$entityMap$1 r0 = ObricUploadEntityCache.a;
        Intrinsics.checkNotNullParameter(r3, "identifier");
        Intrinsics.checkNotNullParameter(r4, "entity");
        Object r1 = ObricUploadEntityCache.c;
        monitor-enter(r1);
        ObricUploadEntityCache.b.put(r3, r4);     // Catch: Throwable -> L7
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r1);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void f(String r4, SingleImageWithTextHandler r5) {
        Intrinsics.checkNotNullParameter(r4, "identifier");
        Intrinsics.checkNotNullParameter(r5, "uploadListener");
        Map<String, Set<oha.a>> r2 = e.a;
        Intrinsics.checkNotNullParameter(r4, "identifier");
        Intrinsics.checkNotNullParameter(r5, "uploadListener");
        int r0 = m.a;
        m.c("ObricUploadDispatcher", "removeUploadListener called, identifier = " + r4);
        Set<oha.a> r6 = e.a.get(r4);
        if (r6 != null) goto L6;
        return;
    L6:
        if (r6.contains(r5) == false) goto L11;
        r6.remove(r5);
        return;
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void h(String r2, SingleImageWithTextHandler r3) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "uploadListener");
        e.a(r2, r3);
    }

    @Override // com.obric.assistant.upload.IObricUploadService
    public final void a(String r2, File r3, Scene r4, oha.a r5) {
        Intrinsics.checkNotNullParameter(r2, "identifier");
        Intrinsics.checkNotNullParameter(r3, "file");
        Intrinsics.checkNotNullParameter(r4, "scene");
        e.a(r2, r5);
        ((ObricFileUploader) this.b.getValue()).c(r2, r3, r4);
    }
}
