package com.suite.lark.platform.component.storage.clean.request;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.suite.lark.platform.component.storage.clean.CleanRequest;
import com.suite.lark.platform.component.storage.clean.PersistentRequest;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import com.suite.lark.platform.component.storage.clean.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cBG\b\u0002\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0012J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/suite/lark/platform/component/storage/clean/request/RemoteClearRequest;", "Lcom/suite/lark/platform/component/storage/clean/PersistentRequest;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "userList", "", "Lcom/suite/lark/platform/component/storage/clean/request/UserInfo;", "uniqueName", "", "retryCount", "", "resources", "whitelistResources", "<init>", "(Ljava/util/List;Ljava/lang/String;ILjava/util/List;Ljava/util/List;)V", "getUserList", "()Ljava/util/List;", "tempResources", "Ljava/util/ArrayList;", "Lcom/suite/lark/platform/component/storage/clean/CleanableResource;", "Lkotlin/collections/ArrayList;", "tempWhitelistResource", "addResource", "", "res", "getResources", "addWhitelistResource", "getWhitelistResources", "Companion", "Builder", "lark-storage_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class RemoteClearRequest extends PersistentRequest<PersistentResource> {
    public static final b Companion = null;
    private static final String Name = null;
    private transient ArrayList<f> tempResources;
    private transient ArrayList<f> tempWhitelistResource;
    private final List<Object> userList;

    public static final class a extends CleanRequest.a<PersistentResource, RemoteClearRequest, a> {
    }

    public static final class b {
        public b() {
        }
    }

    public /* synthetic */ RemoteClearRequest(List r1, String r2, int r3, List r4, List r5, DefaultConstructorMarker r6) {
        this(r1, r2, r3, r4, r5);
    }

    static {
        Companion = new b();
        Name = "remote_clear_all_user";
    }

    public static final String getName() {
        Companion.getClass();
        return access$getName$cp();
    }

    @Override // com.suite.lark.platform.component.storage.clean.CleanRequest
    public List<f> getResources() {
        ArrayList r0 = new ArrayList();
        r0.addAll(super.getResources());
        ArrayList<f> r1 = this.tempResources;
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        return r0;
    }

    @Override // com.suite.lark.platform.component.storage.clean.CleanRequest
    public List<f> getWhitelistResources() {
        ArrayList r0 = new ArrayList();
        List<f> r1 = super.getWhitelistResources();
        if (r1 == null) goto L5;
        r0.addAll(r1);
    L5:
        ArrayList<f> r2 = this.tempWhitelistResource;
        if (r2 == null) goto L8;
        r0.addAll(r2);
    L8:
        return r0;
    }

    public static final /* synthetic */ String access$getName$cp() {
        return Name;
    }

    public final List<Object> getUserList() {
        return this.userList;
    }

    public final void addResource(f r2) {
        Intrinsics.checkNotNullParameter(r2, "res");
        if (this.tempResources != null) goto L5;
        this.tempResources = new ArrayList();
    L5:
        ArrayList<f> r0 = this.tempResources;
        if (r0 == null) goto L9;
        r0.add(r2);
        return;
    }

    public final void addWhitelistResource(f r2) {
        Intrinsics.checkNotNullParameter(r2, "res");
        if (this.tempWhitelistResource != null) goto L5;
        this.tempWhitelistResource = new ArrayList();
    L5:
        ArrayList<f> r0 = this.tempWhitelistResource;
        if (r0 == null) goto L9;
        r0.add(r2);
        return;
    }

    private RemoteClearRequest(List<Object> r1, String r2, int r3, List<? extends PersistentResource> r4, List<? extends PersistentResource> r5) {
        super(r2, r3, r4, r5);
        this.userList = r1;
    }

    public /* synthetic */ RemoteClearRequest(List r7, String r8, int r9, List r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 16) == 0) goto L5;
        r11 = null;
    L5:
        this(r7, r8, r9, r10, r11);
    }
}
