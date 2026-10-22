package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\"\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0003J/\u0010\f\u001a\u00020\u00002$\b\u0002\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R-\u0010\u0002\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/Entity;", "Lcom/bytedance/ee/util/io/NonProguard;", "chatters", "Ljava/util/HashMap;", BuildConfig.FLAVOR, "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/Chatter;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/util/HashMap;)V", "getChatters", "()Ljava/util/HashMap;", "component1", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Entity implements NonProguard {
    private final HashMap<String, Chatter> chatters;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Entity copy$default(Entity r0, HashMap r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.chatters;
    L6:
        return r0.copy(r1);
    }

    public final HashMap<String, Chatter> component1() {
        return this.chatters;
    }

    public final Entity copy(HashMap<String, Chatter> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatters");
        return new Entity(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Entity) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.chatters, ((Entity) r4).chatters) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.chatters.hashCode();
    }

    public String toString() {
        return "Entity(chatters=" + this.chatters + ')';
    }

    public final HashMap<String, Chatter> getChatters() {
        return this.chatters;
    }

    public Entity(HashMap<String, Chatter> r2) {
        Intrinsics.checkNotNullParameter(r2, "chatters");
        this.chatters = r2;
    }
}
