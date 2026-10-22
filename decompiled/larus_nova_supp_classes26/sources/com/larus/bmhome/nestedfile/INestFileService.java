package com.larus.bmhome.nestedfile;

import android.content.Context;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UplinkFileInfo;
import com.larus.office.base.w;
import com.obric.assistant.omnidetailpage.componment.OmniDetailContentComponent;
import h38.d;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import lr8.f;
import lr8.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0002\u0010\u000eJH\u0010\u0011\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&JJ\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&JT\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0019H&¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/nestedfile/INestFileService;", "", "createNestedFileView", "Lcom/larus/NestedFileViewInterface;", "context", "Landroid/content/Context;", "openResourceOnClick", "", "params", "Lcom/larus/bmhome/nestedfile/OpenResourceOnClickParams;", "requireFileUrl", "", "fileInfo", "Lcom/larus/im/bean/message/UplinkFileInfo;", "(Landroid/content/Context;Lcom/larus/im/bean/message/UplinkFileInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "downloadFile", "Lcom/larus/bmhome/nestedfile/StepResult;", "openAudio", "key", MusicAppletPage.KEY_PATH, "message", "Lcom/larus/im/bean/message/Message;", "cxt", "botId", "delegate", "Lcom/larus/bmhome/nestedfile/INestedFileClickDelegate;", "openFile", "targetFileName", "openFileAfterSign", "previewUrl", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INestFileService {
    Object a(Context r1, UplinkFileInfo r2, Continuation<? super String> r3);

    void b(Context r1, String r2, String r3, UplinkFileInfo r4, Message r5, String r6, w.a r7);

    void c(f r1);

    void d(Context r1, String r2, UplinkFileInfo r3, Message r4, String r5, w.a r6);

    d e(Context r1);

    Object f(Context r1, UplinkFileInfo r2, Continuation<? super g> r3);

    void g(String r1, String r2, Message r3, Context r4, UplinkFileInfo r5, String r6, OmniDetailContentComponent.b r7);
}
