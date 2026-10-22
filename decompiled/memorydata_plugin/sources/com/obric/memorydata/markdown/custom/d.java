package com.obric.memorydata.markdown.custom;

import android.content.Context;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/markdown/custom/LinkClickHandler;", "", "onClick", "", "context", "Landroid/content/Context;", EventBody.KEY_VALUE, "", WsConstants.KEY_EXTRA, "", "markdown_lite_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface d {
    void a(Context r1, String r2, Map<String, String> r3);
}
