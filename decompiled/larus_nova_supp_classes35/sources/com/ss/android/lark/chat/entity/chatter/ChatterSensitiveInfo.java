package com.ss.android.lark.chat.entity.chatter;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/ChatterSensitiveInfo;", "Ljava/io/Serializable;", "<init>", "()V", "chatterDepartmentName", BuildConfig.FLAVOR, "getChatterDepartmentName", "()Ljava/lang/String;", "setChatterDepartmentName", "(Ljava/lang/String;)V", "Builder", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatterSensitiveInfo implements Serializable {
    private String chatterDepartmentName;

    public static final class a {
        public String a;

        public a() {
            this.a = BuildConfig.FLAVOR;
        }
    }

    public ChatterSensitiveInfo() {
        this.chatterDepartmentName = BuildConfig.FLAVOR;
    }

    public final String getChatterDepartmentName() {
        return this.chatterDepartmentName;
    }

    public final void setChatterDepartmentName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.chatterDepartmentName = r2;
    }
}
