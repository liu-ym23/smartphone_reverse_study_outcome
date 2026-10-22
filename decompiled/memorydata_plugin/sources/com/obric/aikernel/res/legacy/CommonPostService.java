package com.obric.aikernel.res.legacy;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Url;
import com.bytedance.retrofit2.mime.TypedInput;
import com.obric.capabilitykit.common.Ext;
import kotlin.Metadata;
import okhttp3.RequestBody;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\u0001H'¨\u0006\n"}, d2 = {"Lcom/obric/aikernel/res/legacy/CommonPostService;", "", Ext.KEY_REQUEST, "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "url", "", "body", "Lokhttp3/RequestBody;", "reqInfo", "resource_manager_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface CommonPostService {
    @POST
    Call<TypedInput> request(@Url String r1, @Body RequestBody r2, @ExtraInfo Object r3);
}
