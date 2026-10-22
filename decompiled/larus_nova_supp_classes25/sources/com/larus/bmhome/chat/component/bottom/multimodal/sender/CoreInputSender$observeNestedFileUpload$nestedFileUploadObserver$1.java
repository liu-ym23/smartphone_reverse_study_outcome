package com.larus.bmhome.chat.component.bottom.multimodal.sender;

import androidx.lifecycle.Observer;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.bmhome.nestedfile.INestedFileCacheManagerService;
import com.larus.bmhome.nestedfile.NestedFileCacheManagerService;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001J\u001c\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016R\u0010\u0010\u0005\u001a\u00020\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"com/larus/bmhome/chat/component/bottom/multimodal/sender/CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1", "Landroidx/lifecycle/Observer;", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "Lcom/larus/im/bean/message/UplinkFileEntity;", "context", "Lcom/larus/bmhome/chat/component/bottom/multimodal/sender/CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1;", "hasUpdatedToProcess", "", "", "", "onChanged", "", "it", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 implements Observer<Pair<? extends INestedFileCacheManagerService.FileEvent, ? extends UplinkFileEntity>> {
    public final CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1 a;
    public final Map<String, Boolean> b;
    public final /* synthetic */ NestedFileContent c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ f g;
    public final /* synthetic */ Function1<Message, Unit> h;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[INestedFileCacheManagerService.FileEvent.values().length];
            r0[INestedFileCacheManagerService.FileEvent.INSERT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[INestedFileCacheManagerService.FileEvent.REMOVE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[INestedFileCacheManagerService.FileEvent.UPDATE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            a = r0;
        }
    }

    public final void onChanged(Object r15) {
        Pair r16 = (Pair) r15;
        Intrinsics.checkNotNullParameter(r16, "it");
        int r0 = a.a[((INestedFileCacheManagerService.FileEvent) r16.getFirst()).ordinal()];
        boolean r1 = true;
        if (r0 != 1) goto L5;
        FLogger.a.i("CoreInputSender", "[observeNestedFileUpload] INSERT fileIdentifier:" + ((UplinkFileEntity) r16.getSecond()).getFileIdentifier());
        String r17 = ((UplinkFileEntity) r16.getSecond()).getFileIdentifier();
        if (r17 == null) goto L132;
        this.b.put(r17, Boolean.FALSE);
        return;
    L132:
        return;
    L5:
        if (r0 != 2) goto L7;
        FLogger.a.i("CoreInputSender", "[observeNestedFileUpload] REMOVE fileIdentifier:" + ((UplinkFileEntity) r16.getSecond()).getFileIdentifier());
        String r18 = ((UplinkFileEntity) r16.getSecond()).getFileIdentifier();
        if (r18 == null) goto L130;
        this.b.put(r18, Boolean.FALSE);
        return;
    L130:
        return;
    L7:
        if (r0 != 3) goto L105;
        FLogger.a.i("CoreInputSender", "[observeNestedFileUpload] UPDATE entity:" + r16.getSecond());
        List r2 = this.c.getEntities();
        if (r2 == null) goto L34;
        List r3 = r2;
        if ((r3 instanceof Collection) == true) goto L13;
    L15:
        Iterator r4 = r3.iterator();
    L17:
        if (r4.hasNext() == false) goto L33;
        UplinkFileEntity r5 = (UplinkFileEntity) r4.next();
        Integer r6 = r5.getUpLinkStatus();
        int r7 = UpLinkState.SUCCESS.getValue();
        if (r6 != null) goto L22;
    L23:
        Integer r8 = r5.getUpLinkStatus();
        int r9 = UpLinkState.FAIL.getValue();
        if (r8 != null) goto L27;
    L29:
        boolean r10 = false;
    L31:
        if (r10 == true) goto L17;
    L27:
        if (r8.intValue() != r9) goto L29;
    L30:
        r10 = true;
        goto L31
    L22:
        if (r6.intValue() == r7) goto L30;
    L33:
        boolean r11 = true;
    L35:
        List r12 = this.c.getEntities();
        if (r12 == null) goto L55;
        List r13 = r12;
        if ((r13 instanceof Collection) == true) goto L40;
    L42:
        Iterator r14 = r13.iterator();
    L44:
        if (r14.hasNext() == false) goto L54;
        Integer r19 = ((UplinkFileEntity) r14.next()).getUpLinkStatus();
        int r20 = UpLinkState.SUCCESS.getValue();
        if (r19 != null) goto L49;
    L51:
        boolean r21 = false;
    L52:
        if (r21 == true) goto L44;
    L49:
        if (r19.intValue() != r20) goto L51;
        r21 = true;
    L54:
        boolean r22 = true;
    L56:
        List r23 = this.c.getEntities();
        if (r23 == null) goto L75;
        List r24 = r23;
        if ((r24 instanceof Collection) == true) goto L61;
    L63:
        Iterator r25 = r24.iterator();
    L65:
        if (r25.hasNext() == false) goto L75;
        Integer r26 = ((UplinkFileEntity) r25.next()).getUpLinkStatus();
        int r27 = UpLinkState.FAIL.getValue();
        if (r26 != null) goto L70;
    L72:
        boolean r28 = false;
    L73:
        if (r28 == false) goto L65;
        boolean r29 = true;
    L76:
        FLogger r30 = FLogger.a;
        r30.i("CoreInputSender", "[observeNestedFileUpload] UPDATE isReadyToRemoveObserver:" + r11 + ", isReadyToSend:" + r22 + ", hasFailedContent:" + r29);
        if (r29 == false) goto L79;
        Map r31 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("send_loading", "0")});
    L80:
        if (r11 == false) goto L84;
        if (r29 == false) goto L83;
        zh8.a.a.getSender().v(this.d, this.e, this.c, r31, new g());
        NestedFileCacheManagerService.b.b2(this.e);
    L83:
        NestedFileCacheManagerService.b.g(this.e).removeObserver(this.a);
    L84:
        if (r11 == false) goto L89;
        if (r29 == false) goto L89;
        if (o0.d(this.f) == false) goto L89;
        r30.i("CoreInputSender", "[observeNestedFileUpload] UPDATE remove answer loading");
        f r32 = this.g;
        String r33 = this.f;
        int r34 = f.d;
        r32.getClass();
        zh8.a.a.r1(r33, new com.larus.bmhome.chat.component.bottom.multimodal.sender.a(r31));
    L89:
        String r35 = ((UplinkFileEntity) r16.getSecond()).getFileIdentifier();
        if (r35 == null) goto L102;
        String r36 = this.d;
        String r110 = this.e;
        NestedFileContent r111 = this.c;
        Integer r112 = ((UplinkFileEntity) r16.getSecond()).getUpLinkStatus();
        int r37 = UpLinkState.PROCESSING.getValue();
        if (r112 != null) goto L95;
    L97:
        r1 = false;
    L98:
        if (r1 == false) goto L102;
        Object r113 = ((LinkedHashMap) this.b).get(r35);
        Boolean r38 = Boolean.TRUE;
        if (Intrinsics.areEqual(r113, r38) == true) goto L102;
        this.b.put(r35, r38);
        zh8.a.a.getSender().v(r36, r110, r111, r31, new h());
        goto L102
    L95:
        if (r112.intValue() != r37) goto L97;
    L102:
        if (r22 == false) goto L128;
        u1 r39 = zh8.a.a.getSender();
        String r40 = this.d;
        String r114 = this.e;
        r39.v(r40, r114, this.c, r31, new i(this.h, r114, this));
        return;
    L128:
        return;
    L79:
        r31 = new LinkedHashMap();
        goto L80
    L70:
        if (r26.intValue() != r27) goto L72;
        r28 = true;
        goto L73
    L61:
        if (r24.isEmpty() == false) goto L63;
    L75:
        r29 = false;
        goto L76
    L40:
        if (r13.isEmpty() == false) goto L42;
    L55:
        r22 = false;
        goto L56
    L13:
        if (r3.isEmpty() == false) goto L15;
    L34:
        r11 = false;
        goto L35
    L105:
        throw new NoWhenBranchMatchedException();
    }

    public CoreInputSender$observeNestedFileUpload$nestedFileUploadObserver$1(NestedFileContent r1, String r2, String r3, String r4, f r5, Function1<? super Message, Unit> r6) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.h = r6;
        this.a = this;
        this.b = new LinkedHashMap();
    }
}
