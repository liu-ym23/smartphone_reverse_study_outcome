package com.ss.android.lark.integrator.ccm.im;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class CollaborativeDomainUtils {
    public static final /* synthetic */ int a = 0;

    @AppConfig(key = "group_note_config_page_path")
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/im/CollaborativeDomainUtils$CollaborativePagePath;", "Ljava/io/Serializable;", "path", "", "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
    public static final class CollaborativePagePath implements Serializable {

        @SerializedName("group_note_config_page")
        private final String path;

        public final String getPath() {
            return this.path;
        }

        public CollaborativePagePath(String r2) {
            Intrinsics.checkNotNullParameter(r2, "path");
            this.path = r2;
        }
    }

    static {
    }
}
