package com.larus.bmhome.chat.require;

import android.content.Context;
import android.os.Bundle;
import com.larus.bmhome.chat.bean.PageType;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001:\u0001\rJ\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\tH&¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/chat/require/IMainBotService;", "", "openMainBot", "", "context", "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "isEnableDouYinSdk", "", "getSearchSceneId", "", "isEnableDouyinFeedCocoEntrance", "MainBotParam", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public interface IMainBotService {

    public static final class a {
        public final Bundle a;
        public final int b;
        public final List<Integer> c;
        public final int d;
        public final int e;
        public final int f;
        public final Integer g;

        public a(Bundle r2, int r3, List<Integer> r4, int r5, int r6, int r7, Integer r8) {
            Intrinsics.checkNotNullParameter(r2, "bundle");
            Intrinsics.checkNotNullParameter(r4, "pageList");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
        }

        public /* synthetic */ a(Bundle r10, int r11, List r12, int r13, int r14, int r15, Integer r16, int r17) {
            if ((r17 & 2) == 0) goto L5;
            int r3 = PageType.Chat.getType();
        L7:
            if ((r17 & 4) == 0) goto L9;
            List r4 = CollectionsKt.emptyList();
        L11:
            if ((r17 & 8) == 0) goto L13;
            int r5 = 0;
        L15:
            if ((r17 & 64) == 0) goto L17;
            Integer r8 = null;
        L18:
            this(r10, r3, r4, r5, r14, r15, r8);
            return;
        L17:
            r8 = r16;
            goto L18
        L13:
            r5 = r13;
            goto L15
        L9:
            r4 = r12;
            goto L11
        L5:
            r3 = r11;
            goto L7
        }
    }

    String a();

    boolean b();

    void c(Context r1, a r2);
}
