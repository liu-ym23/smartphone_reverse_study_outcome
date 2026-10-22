package com.larus.business.markdown.api.extplugin.a;

import android.text.Spanned;
import android.widget.TextView;
import com.bytedance.bdinstall.Api;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eH&J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0000H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R \u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b¨\u0006!"}, d2 = {"Lcom/larus/business/markdown/api/extplugin/code/ICustomCodeSpan;", "Lio/noties/markwon/html/IRecyclableSpan;", "code", "", "getCode", "()Ljava/lang/String;", "setCode", "(Ljava/lang/String;)V", "endIndex", "", "getEndIndex", "()Ljava/lang/Integer;", Api.KEY_LANGUAGE, "getLanguage", "payload", "", "", "getPayload", "()Ljava/util/Map;", "startIndex", "getStartIndex", "afterAttach", "", "textView", "Landroid/widget/TextView;", "beforeAttach", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "Landroid/text/Spanned;", "onDetach", "needRemoveView", "", "onReuse", "span", "markdown-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface b {
    String a();

    void a(Spanned r1, b r2);

    void a(TextView r1);

    void a(TextView r1, Spanned r2);

    void a(TextView r1, boolean r2);

    String b();

    Integer c();
}
