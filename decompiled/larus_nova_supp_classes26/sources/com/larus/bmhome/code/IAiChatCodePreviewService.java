package com.larus.bmhome.code;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&¨\u0006\t"}, d2 = {"Lcom/larus/bmhome/code/IAiChatCodePreviewService;", "", "getCodeForPreviewByCodeId", "", "codeId", "showCodePreviewWeb", "", "isSuccess", "getLanguageForPreviewByCodeId", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IAiChatCodePreviewService {
    boolean a(String r1, boolean r2);

    String b(String r1);

    String c(String r1);
}
