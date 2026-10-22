package com.obric.aikernel.middleware.api.alog;

import com.bytedance.news.common.service.manager.IService;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public interface IALogManager extends IService {
    public static final int ALOG_MAX_DIR_SIZE = 104857600;
    public static final int ALOG_PER_FILE_SZIE = 2097152;
    public static final a Companion = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f4503a = null;

        static {
            f4503a = new a();
        }

        private a() {
        }
    }

    static {
        Companion = a.f4503a;
    }

    List<String> getALogFiles(long r10, long r11);

    List<String> getLogFiles();

    void init();

    void setAlogConsumer();
}
