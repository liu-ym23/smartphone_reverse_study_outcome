package androidx.constraintlayout.solver;

import ai.j0;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class Metrics {
    public long additionalMeasures;
    public long barrierConnectionResolved;
    public long bfs;
    public long centerConnectionResolved;
    public long chainConnectionResolved;
    public long constraints;
    public long determineGroups;
    public long errors;
    public long extravariables;
    public long fullySolved;
    public long graphOptimizer;
    public long graphSolved;
    public long grouping;
    public long infeasibleDetermineGroups;
    public long iterations;
    public long lastTableSize;
    public long layouts;
    public long linearSolved;
    public long matchConnectionResolved;
    public long maxRows;
    public long maxTableSize;
    public long maxVariables;
    public long measuredMatchWidgets;
    public long measuredWidgets;
    public long measures;
    public long measuresLayoutDuration;
    public long measuresWidgetsDuration;
    public long measuresWrap;
    public long measuresWrapInfeasible;
    public long minimize;
    public long minimizeGoal;
    public long nonresolvedWidgets;
    public long oldresolvedWidgets;
    public long optimize;
    public long pivots;
    public ArrayList<String> problematicLayouts;
    public long resolutions;
    public long resolvedWidgets;
    public long simpleconstraints;
    public long slackvariables;
    public long tableSizeIncrease;
    public long variables;
    public long widgets;

    public Metrics() {
        this.problematicLayouts = new ArrayList();
    }

    public void reset() {
        this.measures = 0;
        this.widgets = 0;
        this.additionalMeasures = 0;
        this.resolutions = 0;
        this.tableSizeIncrease = 0;
        this.maxTableSize = 0;
        this.lastTableSize = 0;
        this.maxVariables = 0;
        this.maxRows = 0;
        this.minimize = 0;
        this.minimizeGoal = 0;
        this.constraints = 0;
        this.simpleconstraints = 0;
        this.optimize = 0;
        this.iterations = 0;
        this.pivots = 0;
        this.bfs = 0;
        this.variables = 0;
        this.errors = 0;
        this.slackvariables = 0;
        this.extravariables = 0;
        this.fullySolved = 0;
        this.graphOptimizer = 0;
        this.graphSolved = 0;
        this.resolvedWidgets = 0;
        this.oldresolvedWidgets = 0;
        this.nonresolvedWidgets = 0;
        this.centerConnectionResolved = 0;
        this.matchConnectionResolved = 0;
        this.chainConnectionResolved = 0;
        this.barrierConnectionResolved = 0;
        this.problematicLayouts.clear();
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("\n*** Metrics ***\nmeasures: ");
        r5.append(this.measures);
        r5.append("\nmeasuresWrap: ");
        r5.append(this.measuresWrap);
        r5.append("\nmeasuresWrapInfeasible: ");
        r5.append(this.measuresWrapInfeasible);
        r5.append("\ndetermineGroups: ");
        r5.append(this.determineGroups);
        r5.append("\ninfeasibleDetermineGroups: ");
        r5.append(this.infeasibleDetermineGroups);
        r5.append("\ngraphOptimizer: ");
        r5.append(this.graphOptimizer);
        r5.append("\nwidgets: ");
        r5.append(this.widgets);
        r5.append("\ngraphSolved: ");
        r5.append(this.graphSolved);
        r5.append("\nlinearSolved: ");
        return j0.o(r5, this.linearSolved, "\n");
    }
}
