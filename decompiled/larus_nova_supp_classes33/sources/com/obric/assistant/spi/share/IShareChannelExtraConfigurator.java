package com.obric.assistant.spi.share;

import java.util.List;
import kn7.a;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&J/\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/spi/share/IShareChannelExtraConfigurator;", "", "isAvailable", "", "configureDouyinExtra", "", "shareExtra", "hashTags", "", "", "configureWechatMiniAppExtra", "miniAppId", "miniAppPath", "miniProgramType", "", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "obric_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IShareChannelExtraConfigurator {
    void a(a r1, String r2, Integer r3);

    void b(a r1, List r2);
}
