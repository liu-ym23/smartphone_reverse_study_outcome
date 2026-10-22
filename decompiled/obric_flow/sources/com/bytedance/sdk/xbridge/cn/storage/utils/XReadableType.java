package com.bytedance.sdk.xbridge.cn.storage.utils;

import android.annotation.SuppressLint;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/storage/utils/XReadableType;", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
@SuppressLint({"CI_ByteDanceKotlinRules_Enum_Fields_All_Uppercase"})
public final enum XReadableType extends Enum<XReadableType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ XReadableType[] f7483a = null;

    static {
        f7483a = new XReadableType[]{new XReadableType("Null", 0), new XReadableType("Boolean", 1), new XReadableType("Number", 2), new XReadableType("Int", 3), new XReadableType("String", 4), new XReadableType("Map", 5), new XReadableType("Array", 6), new XReadableType("Long", 7)};
    }

    public XReadableType(String r5, int r10) {
        super(r5, r10);
    }

    public static XReadableType valueOf(String r5) {
        return (XReadableType) Enum.valueOf(XReadableType.class, r5);
    }

    public static XReadableType[] values() {
        return (XReadableType[]) f7483a.clone();
    }
}
