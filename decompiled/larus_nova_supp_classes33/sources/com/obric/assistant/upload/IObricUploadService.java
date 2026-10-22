package com.obric.assistant.upload;

import com.larus.im.bean.message.UplinkFileEntity;
import com.obric.assistant.chat.internal.SingleImageWithTextHandler;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.io.File;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bg\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017J\b\u0010\u0002\u001a\u00020\u0003H&J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H&J,\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0006\u001a\u00020\u0003H&J\u0016\u0010\u0012\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0011H&¨\u0006\u0018"}, d2 = {"Lcom/obric/assistant/upload/IObricUploadService;", "", "generateUploadIdentifier", "", "addUploadListener", "", "identifier", "uploadListener", "Lcom/obric/assistant/upload/IObricUploadListener;", "removeUploadListener", "removeAllUploadListener", "uploadImage", "file", "Ljava/io/File;", "scene", "Lcom/obric/assistant/upload/Scene;", "getUploadCache", "Lcom/larus/im/bean/message/UplinkFileEntity;", "deleteRemoteResources", "identifiers", "", "addUsedCache", "entity", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricUploadService {
    public static final a a = null;

    public static final class a {
        public static final /* synthetic */ a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public static IObricUploadService a() {
            return (IObricUploadService) ServiceManager.get().getService(IObricUploadService.class, false, false);
        }
    }

    static {
        a = a.a;
    }

    void a(String r1, File r2, Scene r3, oha.a r4);

    void b(String r1, UplinkFileEntity r2);

    void c(String r1);

    String d();

    void e(List<String> r1);

    void f(String r1, SingleImageWithTextHandler r2);

    UplinkFileEntity g(String r1);

    void h(String r1, SingleImageWithTextHandler r2);
}
