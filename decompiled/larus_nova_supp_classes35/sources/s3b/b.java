package s3b;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.AudioContent;
import com.ss.android.lark.chat.utils.h0;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import q3b.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b implements hya.c<String, f5b.b> {
    public final /* synthetic */ f5b.b a;

    public class a extends com.ss.android.lark.chatbase.model.c.a<f5b.b> {
        public a(f5b.b r1) {
            super(r1);
        }

        public final Object a(Object r4) {
            f5b.b r5 = (f5b.b) r4;
            if (r5 == null) goto L49;
            Message.Type r0 = r5.getMessage().getType();
            if (((f5b.b) this.a).getMessage().getType() != r0) goto L48;
            if (r0 != Message.Type.AUDIO) goto L16;
            AudioContent r6 = (AudioContent) r5.getMessage().getContent();
            AudioContent r1 = (AudioContent) ((f5b.b) this.a).getMessage().getContent();
            if (TextUtils.isEmpty(r1.getLocalFilePath()) == false) goto L12;
            r1.setLocalFilePath(r6.getLocalFilePath());
            r1.setAudioWaveBytes(r6.getAudioWaveBytes());
        L12:
            int r2 = q3b.a.a;
            if ((!FeatureGatingModule.getFeatureGatingService().isEnable("im.message.audio_text_result_disable")) == false) goto L48;
            q3b.a.a(r6, r1);
            goto L48
        L16:
            if (r0 == Message.Type.POST) goto L26;
            if (r0 == Message.Type.TEXT) goto L26;
            if (r0 == Message.Type.IMAGE) goto L26;
            if (r0 == Message.Type.MERGE_FORWARD) goto L26;
            if (h0.k(((f5b.b) this.a).getMessage()) == false) goto L48;
        L26:
            if (((f5b.b) this.a).getTranslateInfo() != null) goto L42;
            ((f5b.b) this.a).setTranslateInfo(r5.getTranslateInfo());
            if (((f5b.b) this.a).getTranslateInfo() != null) goto L30;
        L36:
            Message r3 = ((f5b.b) this.a).getMessage();
            Message r7 = r5.getMessage();
            if (r3 == null) goto L42;
            if (r7 == null) goto L42;
            r3.setTranslateLanguage(r7.getTranslateLanguage());
            r3.setTranslateDisplayRule(r7.getTranslateDisplayRule());
            r3.setTranslatedManually(r7.isTranslatedManually());
            goto L42
        L30:
            if (((f5b.b) this.a).getTranslateInfo().getMessageContentVersion() >= ((f5b.b) this.a).getMessage().getContentVersion()) goto L36;
            Message r8 = ((f5b.b) this.a).getMessage();
            Message r9 = r5.getMessage();
            if (r8 == null) goto L42;
            if (r9 == null) goto L42;
            r8.setTranslateLanguage(r9.getTranslateLanguage());
            r8.setTranslatedManually(r9.isTranslatedManually());
        L42:
            if (((f5b.b) this.a).getTranslateInfo() == null) goto L45;
            ((f5b.b) this.a).setIsTranslating(false);
            goto L48
        L45:
            if (((f5b.b) this.a).isTranslatingInited() == true) goto L48;
            ((f5b.b) this.a).setIsTranslating(r5.isTranslating());
        L48:
            return (f5b.b) this.a;
        L49:
            return (f5b.b) this.a;
        }
    }

    public final hya.a<f5b.b> a() {
        return new a(this.a);
    }

    public final hya.b<String> b() {
        return new o(this.a.getMessage());
    }

    public b(f5b.b r1) {
        this.a = r1;
    }
}
