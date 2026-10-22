package com.ss.android.lark.conditional.access.display;

import com.bytedance.lark.pb.security.v1.CustomDisplayMGetRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayMGetResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelByKeyRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayModelResponse;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListRequest;
import com.bytedance.lark.pb.security.v1.CustomDisplayPageListResponse;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionRequest;
import com.bytedance.lark.pb.security.v1.QueryPolicyCenterResourceBlockActionResponse;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public interface h {
    Single<QueryPolicyCenterResourceBlockActionResponse> U(QueryPolicyCenterResourceBlockActionRequest.Builder r1);

    Single<CustomDisplayPageListResponse> a(CustomDisplayPageListRequest.Builder r1);

    Single<CustomDisplayMGetResponse> b(CustomDisplayMGetRequest.Builder r1);

    Single<CustomDisplayModelResponse> c(CustomDisplayModelByKeyRequest.Builder r1);

    Single<CustomDisplayModelResponse> d(CustomDisplayModelRequest.Builder r1);
}
