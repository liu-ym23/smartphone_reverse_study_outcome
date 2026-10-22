package com.bytedance.ies.ugc.aweme.network;

import androidx.annotation.Keep;
import com.bytedance.bdinstall.Level;
import com.lynx.serval.svg.SVGRenderEngine;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J_\u0010\r\u001a\u00020\f2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000eJC\u0010\r\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0011"}, d2 = {"com/bytedance/ies/ugc/aweme/network/NetworkCommonParams$INetworkCommonParams", "", "", "", "receiver", SVGRenderEngine.PATH, "domain", "", "isApi", "Lcom/bytedance/bdinstall/Level;", "level", "extraInfo", "", "loadTo", "(Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLcom/bytedance/bdinstall/Level;Ljava/util/Map;)V", "url", "(Ljava/lang/String;ZLcom/bytedance/bdinstall/Level;Ljava/util/Map;)Ljava/lang/String;", "aweme-network-api_release"}, k = 1, mv = {1, 4, 1})
public interface NetworkCommonParams$INetworkCommonParams {
    String loadTo(String r5, boolean r10, Level r11, Map<String, String> r12);

    void loadTo(Map<String, String> r5, String r10, String r11, boolean r12, Level r13, Map<String, String> r14);
}
