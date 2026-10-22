package androidx.room.jarjarred.org.antlr.v4.tool;

import androidx.room.jarjarred.org.antlr.v4.Tool;

/* JADX INFO: loaded from: classes.dex */
public class DefaultToolListener implements ANTLRToolListener {
    public Tool tool;

    public DefaultToolListener(Tool r5) {
        this.tool = r5;
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ANTLRToolListener
    public void error(ANTLRMessage r5) {
        String r10 = this.tool.errMgr.getMessageTemplate(r5).render();
        if (this.tool.errMgr.formatWantsSingleLineMessage() == false) goto L5;
        r10 = r10.replace('\n', ' ');
    L5:
        System.err.println(r10);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ANTLRToolListener
    public void info(String r5) {
        if (this.tool.errMgr.formatWantsSingleLineMessage() == false) goto L5;
        r5 = r5.replace('\n', ' ');
    L5:
        System.out.println(r5);
    }

    @Override // androidx.room.jarjarred.org.antlr.v4.tool.ANTLRToolListener
    public void warning(ANTLRMessage r5) {
        String r10 = this.tool.errMgr.getMessageTemplate(r5).render();
        if (this.tool.errMgr.formatWantsSingleLineMessage() == false) goto L5;
        r10 = r10.replace('\n', ' ');
    L5:
        System.err.println(r10);
    }
}
