package com.obric.assistant.privacy;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.security.IObricSecurityService;
import com.obric.assistant.utils.j;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¨\u0006\r"}, d2 = {"Lcom/obric/assistant/privacy/ObricSecurityServiceImpl;", "Lcom/obric/assistant/common/spi/security/IObricSecurityService;", "<init>", "()V", "shouldEraseLog", "", "eraseLogWithTail", "", "origin", "disableReceiveText", "getAdditionalEraseSensitiveKeys", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricSecurityServiceImpl implements IObricSecurityService {
    static {
    }

    public ObricSecurityServiceImpl() {
    }

    public final List<String> b() {
        return CollectionsKt.listOf(new String[]{"origin_content", "semantic_integrity_seg", "X-tt-Token", "summary", DBDefinition.TITLE, "video_captions", "search_queries"});
    }

    public final boolean c() {
        FLogger.a.i("ObricSecurityServiceImpl", "obric shouldEraseLog true");
        return true;
    }

    public final String a(String r1) {
        c();
        return j.d(r1);
    }
}
