package com.bytedance.android.annie.bridge;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\n\u0010\u000bR(\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/annie/bridge/m;", "", "", "Lcom/bytedance/android/annie/bridge/m$a;", "keys", "Ljava/util/List;", "a", "()Ljava/util/List;", "setKeys", "(Ljava/util/List;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class m {

    @SerializedName("keys")
    private List<a> keys;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/annie/bridge/m$a;", "", "", "key", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "d", "(Ljava/lang/String;)V", "biz", "a", "c", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("biz")
        private String biz;

        @SerializedName("key")
        private String key;

        public a() {
            this.key = "";
            this.biz = "";
        }

        public final String a() {
            return this.biz;
        }

        public final String b() {
            return this.key;
        }

        public final void c(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.biz = r10;
        }

        public final void d(String r10) {
            Intrinsics.checkNotNullParameter(r10, "<set-?>");
            this.key = r10;
        }
    }

    public m() {
        this.keys = CollectionsKt.emptyList();
    }

    public final List<a> a() {
        return this.keys;
    }
}
