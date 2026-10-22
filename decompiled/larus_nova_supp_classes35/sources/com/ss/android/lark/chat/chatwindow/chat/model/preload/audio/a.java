package com.ss.android.lark.chat.chatwindow.chat.model.preload.audio;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chatbase.BasePageStore;
import f5b.b;
import hya.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.audio.a$a, reason: collision with other inner class name */
    public static final class C0051a implements c<String, b> {
        public final /* synthetic */ b a;

        /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.model.preload.audio.a$a$a, reason: collision with other inner class name */
        public static final class C0052a extends BasePageStore.d<b> {
            public final /* synthetic */ b a;

            public C0052a(b r1) {
                this.a = r1;
            }

            @Override // com.ss.android.lark.chatbase.BasePageStore.d
            public final b b(b r5) {
                Intrinsics.checkNotNullParameter(r5, "existedItem");
                b r6 = r5.clone();
                Message.Type r0 = r6.getMessage().getType();
                Message.Type r1 = Message.Type.AUDIO;
                if (r0 == r1) goto L5;
            L10:
                return r6;
            L5:
                if (this.a.getMessage().getType() != r1) goto L10;
                AudioContent r2 = (AudioContent) this.a.getMessage().getContent();
                if (TextUtils.isEmpty(r2.getLocalFilePath()) == true) goto L9;
                Content r3 = r6.getMessage().getContent();
                Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.AudioContent");
                ((AudioContent) r3).setLocalFilePath(r2.getLocalFilePath());
                Content r4 = r6.getMessage().getContent();
                Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.AudioContent");
                ((AudioContent) r4).setAudioWaveBytes(r2.getAudioWaveBytes());
            L9:
                Content r7 = r6.getMessage().getContent();
                Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.content.AudioContent");
                ((AudioContent) r7).setFileState(r2.getFileState());
                goto L10
            }
        }

        public final hya.a<b> a() {
            return new C0052a(this.a);
        }

        public final hya.b<String> b() {
            return new BasePageStore.e(this.a.getId());
        }

        public C0051a(b r1) {
            this.a = r1;
        }
    }

    static {
    }

    public static List a(Collection r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        ArrayList r0 = new ArrayList();
        Iterator r4 = ((ArrayList) r3).iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        r0.add(new C0051a((b) r4.next()));
        goto L4
    L6:
        return r0;
    }
}
