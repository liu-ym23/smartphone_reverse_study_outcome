package com.ss.android.lark.diskmanage.storage;

import com.ss.android.lark.vfs.VFSPath;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "invoke"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class UserScopeCipherFileSystem$openOutput$outputStream$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ VFSPath $path;
    final /* synthetic */ UserScopeCipherFileSystem this$0;

    public UserScopeCipherFileSystem$openOutput$outputStream$1(UserScopeCipherFileSystem r1, VFSPath r2) {
        this.this$0 = r1;
        this.$path = r2;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1135invoke() {
        UserScopeCipherFileSystem r0 = this.this$0;
        UserScopeCipherFileSystem.access$encryptFile(r0, UserScopeCipherFileSystem.access$getWriteFile$s17248747(r0, this.$path));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1135invoke();
        return Unit.INSTANCE;
    }
}
