package com.obric.memorydata.memory.lab;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.http.Body;
import com.bytedance.retrofit2.http.ExtraInfo;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.HeaderList;
import com.bytedance.retrofit2.http.Headers;
import com.bytedance.retrofit2.http.POST;
import com.bytedance.retrofit2.http.Query;
import com.bytedance.retrofit2.mime.TypedInput;
import com.google.gson.JsonObject;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u00062\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0001H'J2\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\u000e\b\u0001\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0001\u0010\r\u001a\u00020\u0001H'¨\u0006\u0011"}, d2 = {"Lcom/obric/memorydata/memory/lab/AILabPermissionApi;", "", "getPermission", "Lcom/bytedance/retrofit2/Call;", "Lcom/bytedance/retrofit2/mime/TypedInput;", "resourceKey", "", "assistantVersion", "phoneType", "deviceVersion", "headerList", "", "Lcom/bytedance/retrofit2/client/Header;", "any", "applyPermission", "body", "Lcom/google/gson/JsonObject;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AILabPermissionApi {
    @Headers({"Content-Type:application/json"})
    @POST("/cloud/os/api/permission/apply_v4")
    Call<TypedInput> applyPermission(@Body JsonObject r1, @HeaderList List<Header> r2, @ExtraInfo Object r3);

    @GET("/cloud/os/api/permission/get_v4")
    Call<TypedInput> getPermission(@Query("resource_key") String r1, @Query("assistant_version") String r2, @Query("phone_type") String r3, @Query("system_version") String r4, @HeaderList List<Header> r5, @ExtraInfo Object r6);
}
