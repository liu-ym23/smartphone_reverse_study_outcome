package com.bytedance.android.live.multilink.impl.debug;

import android.widget.TextView;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import vlc.d;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoAnchorWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lvlc/l;", "<init>", "()V", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupSeiDebugInfoAnchorWidget extends PlatformMultiLinkWidget implements l {
    public d a;
    public TextView b;
    public TextView c;

    public static final class a<T> implements Comparator<T> {
        public a() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r3).getPts()), Long.valueOf(((BackupSeiModel) r4).getPts()));
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoAnchorWidget$b", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/message/model/BackupSeiModel;", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class b extends TypeToken<List<? extends BackupSeiModel>> {
        public b() {
        }
    }

    public final int getLayoutId() {
        return 2131567618;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        this.b = (TextView) ((Widget) this).containerView.findViewById(2131390899);
        this.c = (TextView) ((Widget) this).containerView.findViewById(2131390202);
        d r0 = (d) ((Widget) this).dataCenter.get("data_message_manager");
        this.a = r0;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.addMessageListener(MessageType.BACKUP_SEI_MESSAGE.getIntType(), this);
        return;
    L8:
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public BackupSeiDebugInfoAnchorWidget() {
    }

    public final void onMessage(tlc.d r8) {
        if ((r8 instanceof BackupSeiMessage) == false) goto L23;
        List r0 = new ArrayList();
        r0 = (List) GsonHelper.getDefault().fromJson(((BackupSeiMessage) r8).getBackupSeiListStr(), new b().getType());     // Catch: Exception -> L7
    L9:
        List r9 = CollectionsKt.sortedWith(r0, new a());
        BackupSeiModel r1 = (BackupSeiModel) CollectionsKt.firstOrNull(r9);
        long r2 = -1;
        if (r1 == null) goto L12;
        long r3 = r1.getPts();
    L13:
        BackupSeiModel r4 = (BackupSeiModel) CollectionsKt.lastOrNull(r9);
        if (r4 == null) goto L16;
        r2 = r4.getPts();
    L16:
        int r10 = r9.size();
        TextView r5 = this.c;
        if (r5 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("backupMsgHitRate");
    L19:
        r5.setText("backupMsg: \n  listSize = " + r10 + "\n  msgPtsRange = [" + r3 + ", " + r2 + ']');
        return;
    L12:
        r3 = -1;
    L7:
        e = move-exception;
        ((BackupSeiMessage) r8).getBackupSeiListStr();
        e.toString();
        goto L9
    }
}
