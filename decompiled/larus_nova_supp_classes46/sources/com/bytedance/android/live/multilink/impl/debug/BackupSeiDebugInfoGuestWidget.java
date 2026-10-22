package com.bytedance.android.live.multilink.impl.debug;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.liveinteract.api.utils.LiveSeiUtil;
import com.bytedance.android.live.liveinteract.linkpanel.util.o;
import com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget;
import com.bytedance.android.livesdk.message.model.BackupSeiMessage;
import com.bytedance.android.livesdk.message.model.BackupSeiModel;
import com.bytedance.android.livesdkapi.depend.message.MessageType;
import com.bytedance.android.livesdkapi.model.com.bytedance.android.livesdk.config.backupsei.LiveBackupSeiExperimentUtils;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerClient;
import com.bytedance.ies.sdk.widgets.Widget;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import org.json.JSONObject;
import vlc.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoGuestWidget;", "Lcom/bytedance/android/live/liveinteract/linkpanel/widget/PlatformMultiLinkWidget;", "Lvlc/l;", "<init>", "()V", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class BackupSeiDebugInfoGuestWidget extends PlatformMultiLinkWidget implements l {
    public vlc.d a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public long i;

    public static final class a<T> implements Observer {
        public final /* synthetic */ BackupSeiDebugInfoGuestWidget a;

        public a(BackupSeiDebugInfoGuestWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r7) {
            LiveSeiUtil.i.getClass();
            JSONObject r8 = LiveSeiUtil.c((String) r7);
            int r0 = r8.optInt("sei_index");
            TextView r1 = this.a.e;
            if (r1 == null) goto L5;
            r1.setText("cdn_sei_index: " + r0);
        L5:
            JSONObject r9 = r8.optJSONObject("recent_frame_info");
            if (r9 == null) goto L8;
            int r10 = r9.optInt("video_pts");
        L9:
            if (r10 <= 0) goto L14;
            TextView r2 = this.a.g;
            if (r2 == null) goto L15;
            r2.setText("cdn-sei ptsDiff: " + (this.a.i - ((long) r10)));
            return;
        L15:
            return;
        L14:
            return;
        L8:
            r10 = -1;
            goto L9
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ BackupSeiDebugInfoGuestWidget a;

        public b(BackupSeiDebugInfoGuestWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r4) {
            Long r5 = (Long) r4;
            this.a.i = r5.longValue();
            TextView r0 = this.a.d;
            if (r0 == null) goto L6;
            r0.setText("cdn_pts: " + r5);
            return;
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ BackupSeiDebugInfoGuestWidget a;

        public c(BackupSeiDebugInfoGuestWidget r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            BackupSeiDebugInfoGuestWidget r5 = this.a;
            r5.getClass();
            LiveBackupSeiExperimentUtils r0 = LiveBackupSeiExperimentUtils.INSTANCE;
            r0.getTestMock();
            r0.setTestMock(!r0.getTestMock());
            r0.getTestMock();
            TextView r6 = r5.c;
            if (r6 == null) goto L6;
            r6.setText("mockState: " + r0.getTestMock());
            return;
        }
    }

    public static final class d<T> implements Comparator<T> {
        public d() {
        }

        @Override // java.util.Comparator
        public final int compare(T r3, T r4) {
            return ComparisonsKt.compareValues(Long.valueOf(((BackupSeiModel) r3).getPts()), Long.valueOf(((BackupSeiModel) r4).getPts()));
        }
    }

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/bytedance/android/live/multilink/impl/debug/BackupSeiDebugInfoGuestWidget$e", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/bytedance/android/livesdk/message/model/BackupSeiModel;", "multilink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class e extends TypeToken<List<? extends BackupSeiModel>> {
        public e() {
        }
    }

    public final int getLayoutId() {
        return 2131567619;
    }

    @Override // com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final int getScene() {
        return o.c();
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onCreate() {
        super.onCreate();
        this.b = ((Widget) this).containerView.findViewById(2131364766);
        this.c = (TextView) ((Widget) this).containerView.findViewById(2131390959);
        this.d = (TextView) ((Widget) this).containerView.findViewById(2131390289);
        this.e = (TextView) ((Widget) this).containerView.findViewById(2131390290);
        this.f = (TextView) ((Widget) this).containerView.findViewById(2131390202);
        this.g = (TextView) ((Widget) this).containerView.findViewById(2131391214);
        this.h = (TextView) ((Widget) this).containerView.findViewById(2131391215);
        this.a = (vlc.d) ((Widget) this).dataCenter.get("data_message_manager");
        ILivePlayerClient r0 = hs0.a.b.getCurrentClient();
        if (this.a == null) goto L8;
        if (r0 == null) goto L8;
        r0.getEventHub().getSeiUpdate().observe(this, new a(this));
        r0.getEventHub().getPtsUpdate().observe(this, new b(this));
        vlc.d r1 = this.a;
        if (r1 == null) goto L8;
        r1.addMessageListener(MessageType.BACKUP_SEI_MESSAGE.getIntType(), this);
    L8:
        View r2 = this.b;
        if (r2 == null) goto L11;
        r2.setOnClickListener(new c(this));
    L11:
        TextView r3 = this.c;
        if (r3 == null) goto L15;
        r3.setText("mockState: " + LiveBackupSeiExperimentUtils.INSTANCE.getTestMock());
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.linkpanel.widget.PlatformMultiLinkWidget, com.bytedance.android.live.liveinteract.linkbase.api.BaseMultiLinkWidget
    public final void onDestroy() {
        super.onDestroy();
        vlc.d r0 = this.a;
        if (r0 == null) goto L6;
        r0.removeMessageListener(this);
        return;
    }

    public BackupSeiDebugInfoGuestWidget() {
    }

    public final void onMessage(tlc.d r13) {
        if ((r13 instanceof BackupSeiMessage) == false) goto L35;
        List r0 = new ArrayList();
        r0 = (List) GsonHelper.getDefault().fromJson(((BackupSeiMessage) r13).getBackupSeiListStr(), new e().getType());     // Catch: Exception -> L7
    L9:
        List r14 = CollectionsKt.sortedWith(r0, new d());
        BackupSeiModel r1 = (BackupSeiModel) CollectionsKt.firstOrNull(r14);
        long r2 = -1;
        if (r1 == null) goto L12;
        long r3 = r1.getPts();
    L13:
        BackupSeiModel r4 = (BackupSeiModel) CollectionsKt.lastOrNull(r14);
        if (r4 == null) goto L16;
        r2 = r4.getPts();
    L16:
        int r5 = r14.size();
        Iterator r15 = r14.iterator();
        int r6 = 0;
    L18:
        if (r15.hasNext() == false) goto L26;
        if (((BackupSeiModel) r15.next()).getPts() <= this.i) goto L22;
        boolean r7 = true;
    L23:
        if (r7 == true) goto L27;
        r6 = r6 + 1;
    L27:
        TextView r16 = this.f;
        if (r16 == null) goto L36;
        r16.setText("backupMsg: \n  hitRate = " + ((r5 - r6) / r5) + ", \n  listSize = " + r5 + " hitFirstIndex = " + r6 + ", \n  diffRange = [" + (r3 - this.i) + ", " + (r2 - this.i) + "], \n  msgPtsRange = [" + r3 + ", " + r2 + ']');
        return;
    L36:
        return;
    L22:
        r7 = false;
        goto L23
    L26:
        r6 = -1;
        goto L27
    L12:
        r3 = -1;
    L7:
        e = move-exception;
        ((BackupSeiMessage) r13).getBackupSeiListStr();
        e.toString();
        goto L9
    }
}
