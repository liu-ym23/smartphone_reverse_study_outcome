package com.larus.bmhome.nestedfile;

import androidx.lifecycle.MutableLiveData;
import com.larus.im.bean.message.FileParseState;
import com.larus.im.bean.message.FileReviewState;
import com.larus.im.bean.message.NestedFileContent;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import lr8.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001:\u0001*J\u0018\u0010\u0002\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H&J\"\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r0\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u000fH&J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000fH&J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018H&J \u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001bH&J\u0010\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH&JH\u0010\u001f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0006H&J\u001a\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H&J\u0018\u0010)\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¨\u0006+"}, d2 = {"Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService;", "", "getOrCreateNestedFileLiveData", "Landroidx/lifecycle/MutableLiveData;", "Lcom/larus/im/bean/message/NestedFileContent;", "localMsgID", "", "insertOrReplaceNestedFile", "", "content", "removeNestedFile", "getNestedFile", "getOrCreateFileLiveData", "Lkotlin/Pair;", "Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "Lcom/larus/im/bean/message/UplinkFileEntity;", "insertFile", "removeFile", "fileIdentifier", "replaceFile", "updateUplinkFileEntity", "updateFileEntity", "updateUplinkFileInfo", "updateFileInfo", "Lcom/larus/bmhome/nestedfile/NestedFileUplinkUpdateInfo;", "updateFileUpLinkProcess", "process", "", "updateFileStateFromCMD", "info", "Lcom/larus/bmhome/nestedfile/UpdateNestedMessageDownLinkInfo;", "updateFileState", "upLinkState", "Lcom/larus/im/bean/message/UpLinkState;", "fileReviewState", "Lcom/larus/im/bean/message/FileReviewState;", "fileParseState", "Lcom/larus/im/bean/message/FileParseState;", "audioDetailUrl", "getFile", "insertRemovedFile", "removeRemovedFile", "FileEvent", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface INestedFileCacheManagerService {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/nestedfile/INestedFileCacheManagerService$FileEvent;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INSERT", "REMOVE", "UPDATE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FileEvent extends Enum<FileEvent> {
        public static final FileEvent INSERT = null;
        public static final FileEvent REMOVE = null;
        public static final FileEvent UPDATE = null;
        public static final /* synthetic */ FileEvent[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final int value;

        public static EnumEntries<FileEvent> getEntries() {
            return b;
        }

        static {
            FileEvent r0 = new FileEvent("INSERT", 0, 0);
            INSERT = r0;
            FileEvent r1 = new FileEvent("REMOVE", 1, 1);
            REMOVE = r1;
            FileEvent r3 = new FileEvent("UPDATE", 2, 2);
            UPDATE = r3;
            FileEvent[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static FileEvent[] values() {
            return (FileEvent[]) a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static FileEvent valueOf(String r1) {
            return (FileEvent) r27.a.a(FileEvent.class, r1);
        }

        public FileEvent(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static final class a {
        public static /* synthetic */ void a(INestedFileCacheManagerService r9, String r10, String r11, UpLinkState r12, FileReviewState r13, FileParseState r14, int r15) {
            if ((r15 & 4) == 0) goto L5;
            UpLinkState r5 = null;
        L7:
            if ((r15 & 8) == 0) goto L9;
            FileReviewState r6 = null;
        L11:
            if ((r15 & 16) == 0) goto L13;
            FileParseState r7 = null;
        L14:
            r9.d(r10, r11, r5, r6, r7, null);
            return;
        L13:
            r7 = r14;
            goto L14
        L9:
            r6 = r13;
            goto L11
        L5:
            r5 = r12;
            goto L7
        }
    }

    UplinkFileEntity a(String r1, String r2);

    void b(String r1, String r2);

    void b2(String r1);

    NestedFileContent b6(String r1);

    void c(String r1, UplinkFileEntity r2);

    void d(String r1, String r2, UpLinkState r3, FileReviewState r4, FileParseState r5, String r6);

    void e(UpdateNestedMessageDownLinkInfo r1);

    void f(String r1, d r2);

    MutableLiveData<Pair<FileEvent, UplinkFileEntity>> g(String r1);

    void h(String r1, String r2);

    void i(String r1, NestedFileContent r2);

    MutableLiveData<NestedFileContent> j(String r1);

    void k(String r1, UplinkFileEntity r2);

    void l(String r1, UplinkFileEntity r2);

    void m(String r1, String r2, int r3);

    void n(String r1, String r2);
}
