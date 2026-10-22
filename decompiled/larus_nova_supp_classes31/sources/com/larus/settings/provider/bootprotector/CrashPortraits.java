package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0000H\u0016R(\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/larus/settings/provider/bootprotector/CrashPortraits;", "Lcom/bytedance/news/common/settings/api/annotation/IDefaultValueProvider;", "<init>", "()V", "create", "portraits", "", "Lcom/larus/settings/provider/bootprotector/CrashPortrait;", "getPortraits", "()Ljava/util/List;", "setPortraits", "(Ljava/util/List;)V", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CrashPortraits {

    @SerializedName("portraits")
    private List<CrashPortrait> portraits;

    public CrashPortraits() {
    }

    public CrashPortraits create() {
        return new CrashPortraits();
    }

    public final List<CrashPortrait> getPortraits() {
        return this.portraits;
    }

    /* JADX INFO: renamed from: create, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m100create() {
        return create();
    }

    public final void setPortraits(List<CrashPortrait> r1) {
        this.portraits = r1;
    }
}
