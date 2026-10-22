package com.ss.android.agilelogger.formatter.b;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class a implements com.ss.android.agilelogger.formatter.a<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Date f15013a;

    public a() {
        this("MM-dd HH:mm:ss");
    }

    public a(String r1) {
        this.f15013a = new Date();
    }

    @Override // com.ss.android.agilelogger.formatter.a
    public /* synthetic */ String a(String r3) {
        return a2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: a, reason: avoid collision after fix types in other method */
    public String a2(String r1) {
        return r1;
    }
}
